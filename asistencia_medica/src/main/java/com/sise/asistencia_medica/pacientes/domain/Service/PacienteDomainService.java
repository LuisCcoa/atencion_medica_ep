package com.sise.asistencia_medica.pacientes.domain.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.asistencia_medica.pacientes.domain.entities.Pacientes;
import com.sise.asistencia_medica.pacientes.domain.repository.pacienteRepository;

@Service
public class PacienteDomainService {

    @Autowired
    pacienteRepository pacienteRepository;
    
    public Pacientes insertarPaciente(Pacientes paciente){
       return pacienteRepository.save(paciente);
    }

    public List<Pacientes> listarPacientes(){
        return pacienteRepository.findAll();
    }
    
    // Listar todos los pacientes
    public List<Pacientes> findAll() {
        return pacienteRepository.findAll();
    }

    // Buscar paciente por ID
    public Optional<Pacientes> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    // Crear o actualizar paciente
    public Pacientes save(Pacientes paciente) {
        return pacienteRepository.save(paciente);
    }

    // Verificar existencia por ID
    public boolean existsById(Integer id) {
        return pacienteRepository.existsById(id);
    }

    // Eliminar paciente
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
