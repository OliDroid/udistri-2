package com.uno.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Set;
import com.uno.demo.entities.Paciente;
import com.uno.demo.services.sPaciente;
import com.uno.demo.exceptions.exceptions1;


public class cPaciente {
    @Autowired
    private sPaciente spaciente;

    @GetMapping("/pacientes")
    public ResponseEntity <Set<Paciente>> getPacientes() {
        Set<Paciente> pacientes = spaciente.getPacientes();
                
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

        @GetMapping("/paciente")
        public ResponseEntity <Paciente> getPaciente(long id) {
        Paciente paciente = spaciente.getPacienteById(id)
                .orElseThrow(() -> new exceptions1(id));

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
    public ResponseEntity<String> deletePaciente(@RequestBody long chaopaciente) {
        spaciente.deletePaciente(chaopaciente);
        return new ResponseEntity<>("chao paciente"+chaopaciente, HttpStatus.OK);
    }
}
