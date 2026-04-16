package com.cibertec.semana4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Carrera2JPA")
public class Carrera2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String facultad;
}
