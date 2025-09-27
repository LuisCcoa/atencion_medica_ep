package com.sise.asistencia_medica.pacientes.application.dto.request;

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
