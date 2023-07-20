package com.uno.demo.services;

import java.util.Optional;
import java.util.Set;
import java.util.List;

import com.uno.demo.entities.Cita;
    

public interface sCita {
    
    List<Cita> getCitas();
    Cita getCitaById(long Id);
    Cita createCita(Cita Cita);
    Cita updateCita(Cita Cita);
    void deleteCita(long id);

}