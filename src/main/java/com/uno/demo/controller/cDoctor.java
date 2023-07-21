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
import com.uno.demo.entities.Doctor;
import com.uno.demo.services.sDoctor;
import com.uno.demo.exceptions.exceptions1;

public class cDoctor {
    @Autowired
    private sDoctor sdoctor;

    @GetMapping("/doctors")
    public ResponseEntity<Set<Doctor>> getDoctors() {
        Set<Doctor> doctors = sdoctor.getDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/doctor")
    public ResponseEntity<Doctor> getDoctor(long id) {
        Doctor doctor = sdoctor.getDoctorById(id)
                .orElseThrow(() -> new exceptions1(id));

        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor undoc = sdoctor.createDoctor(doctor);
        return new ResponseEntity<>(undoc, HttpStatus.CREATED);
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        Doctor udoctor = sdoctor.updateDoctor(doctor);
        return new ResponseEntity<>(udoctor, HttpStatus.OK);
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<String> deletePaciente(@RequestBody long chaodoctor) {
        sdoctor.deleteDoctor(chaodoctor);
        return new ResponseEntity<>("chao doctor" + chaodoctor, HttpStatus.OK);
    }
}