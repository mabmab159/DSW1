package com.cibertec.semana2.service;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService{
    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll(){
        return alumnoRepository.findAll();
    }

    public Alumno save(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Alumno getAlumnoById(Long id){
        return alumnoRepository.getReferenceById(id);
    }
}
