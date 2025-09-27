package com.sise.asistencia_medica.medicamentos.application.dto.request;

import lombok.Data;

@Data
public class insertRequestMedicamento {
    private String nombre;
    private String descripcion;
    private String dosis;
}
