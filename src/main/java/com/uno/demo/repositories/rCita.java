package com.uno.demo.repositories;

import com.uno.demo.entities.Cita;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;
import java.util.Optional;


public interface rCita extends CrudRepository<Cita, Long>{
    
    Set<Cita> findAll();

    Optional<Cita> findById(long id);

    Set<Cita> findByPaciente(long id);

    Set<Cita> findByDoctor(long id);

}