package com.sise.asistencia_medica.medicamentos.application.dto.response;

import lombok.Data;

@Data
public class insertResponseMedicamento {
    private String nombre;
    private String descripcion;
    private String dosis;
}
