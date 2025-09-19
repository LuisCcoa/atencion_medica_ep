package com.sise.atencion_medica_ep.atencionmedica.application.dto.request;

import java.util.Date;

import lombok.Data;

@Data
public class insertRequestPaciente {
    private String nombre;
    private String apellido;
    private Date fechanacimiento;
    private String sexo;
    private String direccion;
    private String telefono ;
    private String email;
}
