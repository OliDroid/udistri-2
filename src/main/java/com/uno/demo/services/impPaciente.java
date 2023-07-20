package com.uno.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.demo.entities.Paciente;
/*import com.example.myshop.exception.ProductNotFoundException;*/
import com.uno.demo.repositories.rCita;
import com.uno.demo.repositories.rPaciente;

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
public class impPaciente implements sPaciente {

    @Autowired
    private rPaciente rpaciente;

    @Override
    public Set<Paciente> getPacientes() {
        return rpaciente.findAll();
    }


    @Override
    public Paciente getPacienteById(long id) {
        return rpaciente.findById(id);
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return rpaciente.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Paciente npaciente) {
        Paciente paciente = rpaciente.findById(npaciente.getCedula())
                .orElseThrow(() -> new ProductNotFoundException(npaciente.getCedula()));
        return rpaciente.save(npaciente);
    }

    @Override
    public void deletePaciente(long id) {
        rpaciente.findById(id);
                
        rpaciente.deleteById(id);
    }
}