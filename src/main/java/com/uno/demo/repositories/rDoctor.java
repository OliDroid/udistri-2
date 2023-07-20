package com.uno.demo.repositories;

import com.uno.demo.entities.Doctor;


import org.springframework.data.repository.CrudRepository;
import java.util.Set;
import java.util.List;


public interface rDoctor extends CrudRepository<Doctor, Long>{
    
    List<Doctor> findAll();

    Doctor findById(long id);

    Set<Doctor> findByCategory(String category);

    Set<Doctor> findByNameAndPrice(String name, float price);

}