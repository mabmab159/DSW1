package com.cibertec.semana3.dtos;

import lombok.*;

@Data //Getter, Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoRequestDTO {
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private Integer version;
}
