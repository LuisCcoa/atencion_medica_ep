package com.sise.atencion_medica_ep.atencionmedica.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.atencion_medica_ep.atencionmedica.application.dto.request.insertRequestPaciente;
import com.sise.atencion_medica_ep.atencionmedica.application.dto.response.insertResponsePaciente;
import com.sise.atencion_medica_ep.atencionmedica.application.mapper.insertarPacienteMapper;
import com.sise.atencion_medica_ep.atencionmedica.domain.Service.PacienteDomainService;
import com.sise.atencion_medica_ep.atencionmedica.domain.entities.Pacientes;

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
