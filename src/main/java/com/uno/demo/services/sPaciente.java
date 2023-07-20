package com.uno.demo.services;

import java.util.List;
import java.util.Set;

import com.uno.demo.entities.Paciente;
    

public interface sPaciente {
    
    List <Paciente> getPacientes();
    Paciente getPacienteById(long Id);
    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(Paciente paciente);
    void deletePaciente(long id);

}