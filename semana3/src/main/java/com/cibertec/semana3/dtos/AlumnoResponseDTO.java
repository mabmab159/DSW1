package com.cibertec.semana3.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
}
