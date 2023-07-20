package com.uno.demo.repositories;

import com.uno.demo.entities.Paciente;

/*import org.hibernate.mapping.List;*/
import org.springframework.data.repository.CrudRepository;
import java.util.Set;
import java.util.List;


public interface rPaciente extends CrudRepository<Paciente, Long>{
    Set <Paciente> findAll();

    Paciente findById(long id);

    Set<Paciente> findByCategory(String category);

    Set<Paciente> findByNameAndPrice(String name, float price);
}