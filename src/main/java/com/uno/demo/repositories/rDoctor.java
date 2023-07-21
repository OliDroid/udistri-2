package com.uno.demo.repositories;

import com.uno.demo.entities.Doctor;


import org.springframework.data.repository.CrudRepository;
import java.util.Set;
import java.util.Optional;


public interface rDoctor extends CrudRepository<Doctor, Long>{
    
    Set<Doctor> findAll();

    Optional<Doctor> findById(long id);


}