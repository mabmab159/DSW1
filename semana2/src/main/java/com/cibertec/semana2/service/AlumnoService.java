package com.cibertec.semana2.service;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.getReferenceById(id); //Funciona si existe un elemento con ese ID: 14
    }

    public Alumno updateAlumnoById(Long id, Alumno alumno) {
        // 1. Verificar si existe un Alumno con el id previo
        Optional<Alumno> alumnoEncontrado = alumnoRepository.findById(id);
        // 2.1. Si existe, actualizar el registro
        if (alumnoEncontrado.isPresent()) {
            alumno.setId(id);
        } else {
            // 2.2. Si no existe, crear el registro | Elevar exception
            alumno.setId(null);
        }
        return alumnoRepository.save(alumno);
    }
}
