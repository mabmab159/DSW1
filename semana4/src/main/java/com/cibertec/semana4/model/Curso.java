package com.cibertec.semana4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="CursoJPA")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int aforo;
    private int ciclo;
    @ManyToMany (mappedBy = "curso")
    private List<Alumno> alumno;
}
