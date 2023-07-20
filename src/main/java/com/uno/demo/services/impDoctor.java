package com.uno.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.demo.entities.Doctor;
/*import com.example.myshop.exception.ProductNotFoundException;*/
import com.uno.demo.repositories.rCita;
import com.uno.demo.repositories.rDoctor;

import java.util.List;
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
    public List<Doctor> getDoctors() {
        return rdoctor.findAll();
    }


    @Override
    public Doctor getDoctorById(long id) {
        return rdoctor.findById(id);
    }

    @Override
    public Doctor createDoctor(Doctor Doctor) {
        return rdoctor.save(Doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor nDoctor) {
        Doctor Doctor = rdoctor.findById(nDoctor.getCedula())
                .orElseThrow(() -> new ProductNotFoundException(nDoctor.getCedula()));
        return rdoctor.save(nDoctor);
    }

    @Override
    public void deleteDoctor(long id) {
        rdoctor.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        rdoctor.deleteById(id);
    }
}