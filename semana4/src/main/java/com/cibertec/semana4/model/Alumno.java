package com.cibertec.semana4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "AlumnoJPA", indexes = {
        @Index(name="idx_nombre", columnList = "name"), // nombre
        @Index(name="idx_apellido", columnList = "apellido"), // apellido
        @Index(name="idx_nombre_apellido", columnList = "name, apellido")
}) // nombre, apellido => select * from AlumnoJPA where nombre='Miguel'
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    private Long id;
    @Column(name = "name",  nullable = false, length = 50)
    //@Size(min=50, max=50) //Esta anotacion deberia estar en el DTO de entrada
    //@NotNull //Esta anotacion deberia estar en el DTO de entrada
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    @ManyToOne
    private Carrera carrera; //Bidireccional
    @OneToOne
    private Persona persona;
    @ManyToOne
    private Carrera2 carrera2; //Unidireccional
    @OneToOne
    private Persona2 persona2;
    @ManyToMany
    private List<Curso> curso; //Bidireccional
}
