package com.uno.demo.entities;

import lombok.*;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "doctor")
public class Doctor {
    
    @Id
    private long id;

    @Column
    private String nombre;

    @Column
    private String apellido;
    
    @Column
    private long consultorio;
    
    @Column
    private String mail;
    
    @Column
    private String especialidad;
}