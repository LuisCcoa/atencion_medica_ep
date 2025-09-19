package com.sise.atencion_medica_ep.atencionmedica.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.atencion_medica_ep.atencionmedica.application.dto.request.insertRequestPaciente;
import com.sise.atencion_medica_ep.atencionmedica.application.dto.response.insertResponsePaciente;
import com.sise.atencion_medica_ep.atencionmedica.application.service.PacienteAplicationService;



@RestController
@RequestMapping("/atencionmedicas")
public class PacientesController {

    @Autowired
    private PacienteAplicationService proyectoAplicationService;

    @PostMapping("")
    public ResponseEntity<insertResponsePaciente> insertarPaciente(
        @RequestBody insertRequestPaciente requestDto
    ){
        try{
            insertResponsePaciente responseDto = proyectoAplicationService.insertPaciente(requestDto);
            return ResponseEntity.ok(responseDto);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
