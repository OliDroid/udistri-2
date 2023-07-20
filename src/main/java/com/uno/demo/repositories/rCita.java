package com.uno.demo.repositories;

import com.uno.demo.entities.Cita;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;
import java.util.List;


public interface rCita extends CrudRepository<Cita, Long>{
    
    List<Cita> findAll();

    Cita findById(long id);

    Set<Cita> findByIdPaciente(long id);

    Set<Cita> findByIdDoctor(long id);

}