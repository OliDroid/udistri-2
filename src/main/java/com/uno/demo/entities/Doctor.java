package com.uno.demo.entities;

import lombok.*;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "doctor")
public class Doctor {
    
    @Id
    private Long cedula;

    @Column
    private String nombre;

    @Column
    private String apellido;
    
    @Column
    private Long consultorio;
    
    @Column
    private String email;
    
    @Column
    private String especialidad;
}