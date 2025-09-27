package com.sise.asistencia_medica.medicamentos.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.asistencia_medica.medicamentos.application.dto.request.insertRequestMedicamento;
import com.sise.asistencia_medica.medicamentos.application.dto.response.insertResponseMedicamento;
import com.sise.asistencia_medica.medicamentos.application.mapper.insertarMedicamentoMapper;
import com.sise.asistencia_medica.medicamentos.domain.entities.Medicamentos;
import com.sise.asistencia_medica.medicamentos.domain.service.MedicamentoDomainService;

@Service
public class MedicamentoAplicationService {
    @Autowired
    MedicamentoDomainService medicamentoDomainService;

    @Autowired
    insertarMedicamentoMapper insertarMedicamentoMapper;
    public insertResponseMedicamento insertMedicamento(insertRequestMedicamento requestDto){
        Medicamentos medicamentos = medicamentoDomainService.insertarMedicamentos(insertarMedicamentoMapper.requestToEntity(requestDto));
        return insertarMedicamentoMapper.entityToResponse(medicamentos);
    }
}
