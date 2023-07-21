package com.uno.demo.entities;

import lombok.*;

import jakarta.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long paciente;

    @Column
    private long doctor;

    @Column
    private String fecha;

}