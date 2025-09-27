package com.sise.asistencia_medica.medicamentos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.asistencia_medica.medicamentos.domain.entities.Medicamentos;
import com.sise.asistencia_medica.medicamentos.domain.repository.medicamentoRepository;

@Service
public class MedicamentoDomainService {
    
    @Autowired
    medicamentoRepository medicamentoRepository;

    public Medicamentos insertarMedicamentos(Medicamentos medicamentos){
        return medicamentoRepository.save(medicamentos);
    }

    public List<Medicamentos> listarMedicamentos(){
        return medicamentoRepository.findAll();
    } 
    
    //listar los medicametos
    public List<Medicamentos> finAll(){
        return medicamentoRepository.findAll();
    }

    //Buscar paciente por ID
    public Optional<Medicamentos> findById(Integer id){
        return medicamentoRepository.findById(id);
    }

    //actualizar medicamentos
    public Medicamentos save(Medicamentos medicamentos){
        return medicamentoRepository.save(medicamentos);
    }

    //Verificar existencia por ID
    public boolean existsById(Integer id){
        return medicamentoRepository.existsById(id);
    }

    //Eliminar medicamentos
    public void deleteById(Integer id){
        medicamentoRepository.deleteById(id);
    }
}
