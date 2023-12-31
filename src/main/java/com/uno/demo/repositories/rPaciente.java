package com.uno.demo.repositories;

import com.uno.demo.entities.Paciente;

/*import org.hibernate.mapping.List;*/
import org.springframework.data.repository.CrudRepository;
import java.util.Set;
import java.util.Optional;


public interface rPaciente extends CrudRepository<Paciente, Long>{
    Set<Paciente> findAll();

    Optional<Paciente> findById(long id);


}