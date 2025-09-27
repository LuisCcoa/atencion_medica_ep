package com.sise.asistencia_medica.pacientes.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.asistencia_medica.common.application.iEntityDtoMapper;
import com.sise.asistencia_medica.pacientes.application.dto.request.insertRequestPaciente;
import com.sise.asistencia_medica.pacientes.application.dto.response.insertResponsePaciente;
import com.sise.asistencia_medica.pacientes.domain.entities.Pacientes;
@Component
public class insertarPacienteMapper implements iEntityDtoMapper<Pacientes,insertRequestPaciente,insertResponsePaciente> {

    @Override
    public Pacientes requestToEntity(insertRequestPaciente requestDto) {
        Pacientes paciente = new Pacientes();
        paciente.setNombre(requestDto.getNombre());
        paciente.setApellido(requestDto.getApellido());
        paciente.setFechanacimiento(requestDto.getFechanacimiento());
        paciente.setSexo(requestDto.getSexo());
        paciente.setDireccion(requestDto.getDireccion());
        paciente.setTelefono(requestDto.getTelefono());
        paciente.setEmail(requestDto.getEmail());
        return paciente;
    }

    @Override
    public insertResponsePaciente entityToResponse(Pacientes entity) {
        insertResponsePaciente responseDto = new insertResponsePaciente();
        responseDto.setNombre(entity.getNombre());
        responseDto.setApellido(entity.getApellido());
        responseDto.setFechanacimiento(entity.getFechanacimiento());
        responseDto.setSexo(entity.getSexo());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setEmail(entity.getEmail());
    return responseDto;
    }
}
