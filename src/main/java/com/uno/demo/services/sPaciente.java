package com.uno.demo.services;
import java.util.Optional;
import java.util.Set;

import com.uno.demo.entities.Paciente;
    

public interface sPaciente {
    
    Set<Paciente> getPacientes();
    Optional<Paciente> getPacienteById(long Id);
    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(Paciente paciente);
    void deletePaciente(long id);

}