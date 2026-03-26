package com.cibertec.semana2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotNull //El campo sea no nulo | Que el campo exista
    @NotBlank //El string sea valido | "   "
    @NotEmpty //No este vacio | ""
    private String apellido;
}
