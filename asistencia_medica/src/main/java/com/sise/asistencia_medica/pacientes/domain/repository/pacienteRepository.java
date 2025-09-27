package com.sise.asistencia_medica.pacientes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.asistencia_medica.pacientes.domain.entities.Pacientes;

@Repository
public interface pacienteRepository extends JpaRepository<Pacientes,Integer> {
    
}
