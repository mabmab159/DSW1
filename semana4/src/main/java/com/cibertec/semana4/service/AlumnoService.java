package com.cibertec.semana4.service;

import com.cibertec.semana4.model.Alumno;
import com.cibertec.semana4.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll(){
        return alumnoRepository.findAll();
    }

    public List<Alumno> findAllReverse(){
        return alumnoRepository.findAllOrderByApellidoDesc();
    }
}
