package com.sise.asistencia_medica.pacientes.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.asistencia_medica.pacientes.application.dto.request.insertRequestPaciente;
import com.sise.asistencia_medica.pacientes.application.dto.response.insertResponsePaciente;
import com.sise.asistencia_medica.pacientes.application.service.PacienteAplicationService;
import com.sise.asistencia_medica.pacientes.domain.Service.PacienteDomainService;
import com.sise.asistencia_medica.pacientes.domain.entities.Pacientes;



@RestController
@RequestMapping("/asistenciamedica/pacientes")
public class PacientesController {

    @Autowired
    private PacienteAplicationService proyectoAplicationService;

    @PostMapping("")
    public ResponseEntity<insertResponsePaciente> insertarPaciente(
        @RequestBody insertRequestPaciente requestDto
    ){
        try{
            insertResponsePaciente responseDto = proyectoAplicationService.insertPaciente(requestDto);
            return ResponseEntity.ok(responseDto);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @Autowired
    private PacienteDomainService pacienteDomainService;

    // ---------------------- LISTAR TODOS ----------------------
    @GetMapping
    public ResponseEntity<List<Pacientes>> getAllPacientes() {
        List<Pacientes> pacientes = pacienteDomainService.findAll();
        return ResponseEntity.ok(pacientes);
    }

    // ---------------------- OBTENER POR ID ----------------------
    @GetMapping("/{id}")
    public ResponseEntity<Pacientes> getPacienteById(@PathVariable Integer id) {
        Optional<Pacientes> paciente = pacienteDomainService.findById(id);
        return paciente.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

        // ---------------------- ACTUALIZAR ----------------------
    @PutMapping("/{id}")
    public ResponseEntity<Pacientes> updatePaciente(@PathVariable Integer id, @RequestBody Pacientes pacienteDetails) {
        Optional<Pacientes> pacienteOptional = pacienteDomainService.findById(id);

        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pacientes paciente = pacienteOptional.get();
        paciente.setNombre(pacienteDetails.getNombre());
        paciente.setApellido(pacienteDetails.getApellido());
        paciente.setFechanacimiento(pacienteDetails.getFechanacimiento());
        paciente.setSexo(pacienteDetails.getSexo());
        paciente.setDireccion(pacienteDetails.getDireccion());
        paciente.setTelefono(pacienteDetails.getTelefono());
        paciente.setEmail(pacienteDetails.getEmail());

        Pacientes pacienteActualizado = pacienteDomainService.save(paciente);
        return ResponseEntity.ok(pacienteActualizado);
    }

    // ---------------------- ELIMINAR ----------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Integer id) {
        if (!pacienteDomainService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pacienteDomainService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
