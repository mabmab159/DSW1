package com.cibertec.semana4.service;

import com.cibertec.semana4.model.Alumno;
import com.cibertec.semana4.model.Carrera;
import com.cibertec.semana4.repository.AlumnoRepository;
import com.cibertec.semana4.repository.CarreraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final CarreraRepository carreraRepository;

    public List<Alumno> findAll(){
        return alumnoRepository.findAll();
    }

    public List<Alumno> findAllReverse(){
        return alumnoRepository.findAllOrderByApellidoDesc();
    }

    public Alumno save(Alumno alumno){
        Optional<Carrera> carrera = carreraRepository.findById(Integer.parseInt(String.valueOf(alumno.getCarrera().getId())));
        if(carrera.isPresent()){
            alumno.setCarrera(carrera.get());
            return alumnoRepository.save(alumno);
        }
        return new Alumno();
    }
}
