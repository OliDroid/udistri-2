package com.uno.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.demo.entities.Cita;
import com.uno.demo.repositories.rCita;
import com.uno.demo.exceptions.exceptions1;
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
    public Set<Cita> getCitas() {
        return rcita.findAll();
    }


    @Override
    public Optional<Cita> getCitaById(long id) {
        return rcita.findById(id);
    }

        @Override
    public Set<Cita> getCitaByDoctor(long id) {
        return rcita.findByDoctor(id);
    }

        @Override
    public Set<Cita> getCitaByPaciente(long id) {
        return rcita.findByPaciente(id);
    }

    @Override
    public Cita createCita(Cita Cita) {
        return rcita.save(Cita);
    }

      @Override
    public Cita updateCita(Cita nCita) {
        Cita cita = rcita.findById(nCita.getId())  /*objeto sin sentido */
                .orElseThrow(() -> new exceptions1(nCita.getId()));
        return rcita.save(nCita);
    }

    @Override
    public void deleteCita(long id) {
        rcita.findById(id)
                .orElseThrow(() -> new exceptions1(id));
        rcita.deleteById(id);
    }
}