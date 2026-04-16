package com.cibertec.semana4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonaJPA")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    @OneToOne (mappedBy = "persona")
    private Alumno alumno;
}
