package com.sise.asistencia_medica.medicamentos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.asistencia_medica.medicamentos.domain.entities.Medicamentos;

@Repository
public interface medicamentoRepository extends JpaRepository<Medicamentos,Integer> {
    
}
