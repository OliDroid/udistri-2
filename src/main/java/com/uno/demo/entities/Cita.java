package com.uno.demo.entities;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long idPaciente;

    @Column
    private long idDoctor;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}