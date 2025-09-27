package com.sise.asistencia_medica.pacientes.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.asistencia_medica.pacientes.application.dto.request.insertRequestPaciente;
import com.sise.asistencia_medica.pacientes.application.dto.response.insertResponsePaciente;
import com.sise.asistencia_medica.pacientes.application.mapper.insertarPacienteMapper;
import com.sise.asistencia_medica.pacientes.domain.Service.PacienteDomainService;
import com.sise.asistencia_medica.pacientes.domain.entities.Pacientes;

@Service
public class PacienteAplicationService {
    @Autowired
    PacienteDomainService proyDomainService;

    @Autowired
    insertarPacienteMapper insertarPacienteMapper;
    public insertResponsePaciente insertPaciente(insertRequestPaciente requestDto){
        Pacientes pacientes = proyDomainService.insertarPaciente(insertarPacienteMapper.requestToEntity(requestDto));
        return insertarPacienteMapper.entityToResponse(pacientes);
    }
    

}
