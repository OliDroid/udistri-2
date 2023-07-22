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
import com.uno.demo.entities.Doctor;
import com.uno.demo.services.sDoctor;
import com.uno.demo.exceptions.exceptions1;

@RestController
public class cDoctor {
    @Autowired
    private sDoctor sdoctor;

    @GetMapping("/doctors")
    public ResponseEntity<Set<Doctor>> getDoctors() {
        Set<Doctor> doctors = sdoctor.getDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
          public ResponseEntity<Doctor> getDoctor(@PathVariable long id) {
        System.out.println(id);
        Doctor doctor = sdoctor.getDoctorById(id)
        .orElseThrow(() -> new exceptions1(id));
        

        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor undoc = sdoctor.createDoctor(doctor);
        return new ResponseEntity<>(undoc, HttpStatus.CREATED);
    }

    @PutMapping("/doctor")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        Doctor udoctor = sdoctor.updateDoctor(doctor);
        return new ResponseEntity<>(udoctor, HttpStatus.OK);
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id) {
        sdoctor.deleteDoctor(id);
        return new ResponseEntity<String>("Chao Doctor " + id, HttpStatus.OK);
    }

}