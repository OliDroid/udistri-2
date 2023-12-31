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
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.Set;
import com.uno.demo.entities.Paciente;
import com.uno.demo.services.sPaciente;
import com.uno.demo.exceptions.exceptions1;

@RestController
public class cPaciente {
    @Autowired
    private sPaciente spaciente;

    @GetMapping("/pacientes")
    public ResponseEntity <Set<Paciente>> Pacientes() {
        Set<Paciente> pacientes = spaciente.getPacientes();
        System.out.println(pacientes);
                
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

        @GetMapping("/paciente/{id}")
        public ResponseEntity<Paciente> getPaciente(@PathVariable long id) {
        System.out.println(id);
        Paciente paciente = spaciente.getPacienteById(id)
        .orElseThrow(() -> new exceptions1(id));
        

        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente unpa = spaciente.createPaciente(paciente);
        return new ResponseEntity<>(unpa, HttpStatus.CREATED);
    }

    @PutMapping("/paciente")
    public ResponseEntity<Paciente> modifyPaciente(@RequestBody Paciente paciente) {
        spaciente.updatePaciente(paciente);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable long id) {
        spaciente.deletePaciente(id);
        return new ResponseEntity<String>("Chao señor enfermo " + id, HttpStatus.OK);
    }
}
