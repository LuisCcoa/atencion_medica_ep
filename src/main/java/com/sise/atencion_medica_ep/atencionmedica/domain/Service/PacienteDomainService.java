package com.sise.atencion_medica_ep.atencionmedica.domain.Service;

import org.springframework.stereotype.Service;

import com.sise.atencion_medica_ep.atencionmedica.domain.entities.Pacientes;

@Service
public class PacienteDomainService {
    public Pacientes insertarPaciente(Pacientes paciente){
        paciente.setIdPaciente(1);
        return paciente;
    }
}
