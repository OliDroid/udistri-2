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

import java.util.Set;
import com.uno.demo.entities.Cita;
import com.uno.demo.entities.Doctor;
import com.uno.demo.services.sCita;
import com.uno.demo.exceptions.exceptions1;

@RestController
public class cCita {
    @Autowired
    private sCita scita;

    @GetMapping("/citas")
    public ResponseEntity <Set<Cita>> getCitas() {
        Set<Cita> citas = scita.getCitas();
                
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

        @GetMapping("/cita/{id}")
        public ResponseEntity<Cita> getCita(@PathVariable long id) {
        System.out.println(id);
        Cita cita = scita.getCitaById(id)
        .orElseThrow(() -> new exceptions1(id));
        

        return new ResponseEntity<>(cita, HttpStatus.OK);
    }

    @PostMapping("/cita")
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita unacita = scita.createCita(cita);
        return new ResponseEntity<>(unacita, HttpStatus.CREATED);
    }

    @PutMapping("/cita/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Cita cita) {
        Cita ucita = scita.updateCita(cita);
        return new ResponseEntity<>(ucita, HttpStatus.OK);
    }

    @DeleteMapping("/cita/{id}")
    public ResponseEntity<String> deleteCita(@PathVariable long id) {
        scita.deleteCita(id);
        return new ResponseEntity<String>("La cita con id "+id+ "desapareció ", HttpStatus.OK);
    }
}
