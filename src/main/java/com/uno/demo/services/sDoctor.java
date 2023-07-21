package com.uno.demo.services;
import java.util.Optional;
import java.util.Set;

import com.uno.demo.entities.Doctor;
    

public interface sDoctor {
    
    Set <Doctor> getDoctors();
    Optional<Doctor> getDoctorById(long Id);
    Doctor createDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(long id);
}