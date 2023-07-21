package com.uno.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.demo.entities.Doctor;
import com.uno.demo.exceptions.exceptions1;
import com.uno.demo.repositories.rDoctor;


import java.util.Optional;
import java.util.Set;

/**
 * Implementación del Service de productos
 * 
 * @author --
 * @version 1.0
 */
@Service
public class impDoctor implements sDoctor {

    @Autowired
    private rDoctor rdoctor;

    @Override
    public Set<Doctor> getDoctors() {
        return rdoctor.findAll();
    }


    @Override
    public Optional<Doctor> getDoctorById(long id) {
        return rdoctor.findById(id);
    }

    @Override
    public Doctor createDoctor(Doctor Doctor) {
        return rdoctor.save(Doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor nDoctor) {
        Doctor doctor = rdoctor.findById(nDoctor.getCedula())
                .orElseThrow(() -> new exceptions1(nDoctor.getCedula()));
        return rdoctor.save(nDoctor);
    }

    @Override
    public void deleteDoctor(long id) {
        rdoctor.findById(id)
                .orElseThrow(() -> new exceptions1(id));
        rdoctor.deleteById(id);
    }
}