package com.sise.asistencia_medica.medicamentos.infraestructure.controller;

import java.util.List;
import java.util.Optional;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.asistencia_medica.medicamentos.application.dto.request.insertRequestMedicamento;
import com.sise.asistencia_medica.medicamentos.application.dto.response.insertResponseMedicamento;
import com.sise.asistencia_medica.medicamentos.application.service.MedicamentoAplicationService;
import com.sise.asistencia_medica.medicamentos.domain.entities.Medicamentos;
import com.sise.asistencia_medica.medicamentos.domain.service.MedicamentoDomainService;

import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/asistenciamedica/medicamentos")
public class MedicamentosController {

    @Autowired
    private MedicamentoAplicationService medicamentoAplicationService;

    @PostMapping("")
    public ResponseEntity<insertResponseMedicamento> insertarMedicamento(
        @RequestBody insertRequestMedicamento requestDto
    ){
        try {
         insertResponseMedicamento responseDto = medicamentoAplicationService.insertMedicamento(requestDto); 
         return ResponseEntity.ok(responseDto); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Autowired
    private MedicamentoDomainService medicamentoDomainService;
    //Listar todos
    @GetMapping
    public ResponseEntity<List<Medicamentos>>getAllMedicamnetos(){
        List<Medicamentos> medicamentos = medicamentoDomainService.finAll();
        return ResponseEntity.ok(medicamentos);
    }

    //Obtener datos por id
    @GetMapping("/{id}")
    public ResponseEntity<Medicamentos>  getMedicamentoById(@PathVariable Integer id) {
        Optional<Medicamentos> medicamento = medicamentoDomainService.findById(id);
        return medicamento.map(ResponseEntity::ok)
        .orElseGet(()-> ResponseEntity.notFound().build());
    }
    
    //Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Medicamentos> updateMedicamento(@PathVariable Integer id, @RequestBody Medicamentos medicamentosDetails){
        Optional<Medicamentos> medicamentOptional = medicamentoDomainService.findById(id);

        if(medicamentOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        Medicamentos medicamentos = medicamentOptional.get();
        medicamentos.setNombre(medicamentosDetails.getNombre());
        medicamentos.setDescripcion(medicamentosDetails.getDescripcion());
        medicamentos.setDosis(medicamentosDetails.getDosis());
        
        Medicamentos medicamentoUpdate = medicamentoDomainService.save(medicamentos);
        return ResponseEntity.ok(medicamentoUpdate);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Integer id){
        if(!medicamentoDomainService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        medicamentoDomainService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
