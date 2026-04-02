package com.cibertec.semana3.service;

import com.cibertec.semana3.dtos.AlumnoRequestDTO;
import com.cibertec.semana3.dtos.AlumnoResponseDTO;
import com.cibertec.semana3.model.Alumno;
import com.cibertec.semana3.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class AlumnoService { //Voy a recibir un DTO, voy devolver DTO
    private final AlumnoRepository alumnoRepository;
    private final ObjectMapper objectMapper;

    public AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO) {
        Alumno alumnoModel = objectMapper.convertValue(alumnoRequestDTO, Alumno.class); //DTORequest -> Alumno
        var responseRepository = alumnoRepository.save(alumnoModel); // Modelo // Alumno lo mando al repositorio a guardar
        return objectMapper.convertValue(responseRepository, AlumnoResponseDTO.class); // Alumno -> DTOResponse
    }

    public AlumnoResponseDTO updateAlumno(Long id, AlumnoRequestDTO alumnoRequestDTO) {
        Alumno alumnoModel = objectMapper.convertValue(alumnoRequestDTO, Alumno.class);
        alumnoModel.setId(id);
        var responseRepository =  alumnoRepository.save(alumnoModel); //var en js es dinamico
        // JS var pepito = 1; var pepito = "Miguel"
        // Java var:int pepito = 1; int pepito = "Miguel";
        return objectMapper.convertValue(responseRepository, AlumnoResponseDTO.class);
    }
}
