package com.sise.atencion_medica_ep.atencionmedica.domain.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Pacientes")
public class Pacientes{

    @Id
    @Column(name = "id_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "sexo")
    private String sexo;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "email")
    private String email; 
}
