package com.uno.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.uno.demo.entities.Paciente;
import com.uno.demo.services.sPaciente;

public class cPaciente {
    @Autowired
    private sPaciente spaciente;

    @GetMapping("/paciente")
    public ResponseEntity <List<Paciente>> getPacientes() {
        List<Paciente> pacientes = spaciente.getPacientes()
                .orElseThrow(() -> new ProductNotFoundException(id));

        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

        @GetMapping("/paciente")
        public ResponseEntity <Paciente> getPaciente(long id) {
        Paciente paciente = spaciente.getPacienteById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente unpa = spaciente.createPaciente(paciente);
        return new ResponseEntity<>(unpa, HttpStatus.CREATED);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<Paciente> modifyProduct(@RequestBody Paciente paciente) {
        Paciente upaciente = spaciente.updatePaciente(paciente);
        return new ResponseEntity<>(upaciente, HttpStatus.OK);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Response> deletePaciente(@RequestBody long chaopaciente) {
        spaciente.deletePaciente(chaopaciente);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
}
