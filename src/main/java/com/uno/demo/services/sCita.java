package com.uno.demo.services;

import java.util.Set;
import java.util.Optional;

import com.uno.demo.entities.Cita;
    

public interface sCita {
    
    Set<Cita> getCitas();
    Optional<Cita> getCitaById(long Id);
    Set<Cita> getCitaByDoctor(long Id);
    Set<Cita> getCitaByPaciente(long Id);
    Cita createCita(Cita cita);
    Cita updateCita(Cita cita);
    void deleteCita(long id);

}