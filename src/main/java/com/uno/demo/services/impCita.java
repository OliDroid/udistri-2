package com.uno.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.demo.entities.Cita;
/*import com.example.myshop.exception.ProductNotFoundException;*/
import com.uno.demo.repositories.rCita;

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
public class impCita implements sCita {

    @Autowired
    private rCita rcita;

    @Override
    public List<Cita> getCitas() {
        return rcita.findAll();
    }


    @Override
    public Cita getCitaById(long id) {
        return rcita.findById(id);
    }

        @Override
    public Set<Cita> getCitaByDoctor(long id) {
        return rcita.findByIdPaciente(id);
    }

        @Override
    public Set<Cita> getCitaByPaciente(long id) {
        return rcita.findByIdDoctor(id);
    }

    @Override
    public Cita createCita(Cita Cita) {
        return rcita.save(Cita);
    }

    @Override
    public Cita updateCita(Cita nCita) {
        Cita cita/*objeto sin sentido */ = rcita.findById(nCita.getId())
                .orElseThrow(() -> new ProductNotFoundException(nCita.getCedula()));
        return rcita.save(nCita);
    }

    @Override
    public void deleteCita(long id) {
        rcita.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        rcita.deleteById(id);
    }
}