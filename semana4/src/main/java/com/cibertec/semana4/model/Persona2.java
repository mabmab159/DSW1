package com.cibertec.semana4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Persona2JPA")
public class Persona2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
}
