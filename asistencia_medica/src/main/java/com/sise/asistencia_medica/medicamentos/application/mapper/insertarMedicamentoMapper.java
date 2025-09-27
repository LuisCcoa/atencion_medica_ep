package com.sise.asistencia_medica.medicamentos.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.asistencia_medica.common.application.iEntityDtoMapper;
import com.sise.asistencia_medica.medicamentos.application.dto.request.insertRequestMedicamento;
import com.sise.asistencia_medica.medicamentos.application.dto.response.insertResponseMedicamento;
import com.sise.asistencia_medica.medicamentos.domain.entities.Medicamentos;

@Component
public class insertarMedicamentoMapper implements iEntityDtoMapper<Medicamentos,insertRequestMedicamento,insertResponseMedicamento> {

    @Override
    public Medicamentos requestToEntity(insertRequestMedicamento requestDto) {
        Medicamentos medicamentos = new Medicamentos();
        medicamentos.setNombre(requestDto.getNombre());
        medicamentos.setDescripcion(requestDto.getDescripcion());
        medicamentos.setDosis(requestDto.getDosis());
        return medicamentos;
    }

    @Override
    public insertResponseMedicamento entityToResponse(Medicamentos entity) {
        insertResponseMedicamento responseDto = new insertResponseMedicamento();
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setDosis(entity.getDosis());
        return responseDto;
    }
    
}
