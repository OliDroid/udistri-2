package com.uno.demo.services;

import java.util.Optional;
import java.util.Set;
import java.util.List;
import com.uno.demo.entities.Doctor;
    

public interface sDoctor {
    
    List<Doctor> getDoctors();
    Doctor getDoctorById(long Id);
    Doctor createDoctor(Doctor Doctor);
    Doctor updateDoctor(Doctor Doctor);
    void deleteDoctor(long id);

}