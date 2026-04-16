package com.cibertec.semana4.controller;

import com.cibertec.semana4.model.Alumno;
import com.cibertec.semana4.service.AlumnoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping("/list")
    public ResponseEntity<List<Alumno>> findAll(){ // 1 millon de registros
        //return ResponseEntity.ok(alumnoService.findAll().stream().sorted(Comparator.comparing(Alumno::getApellido)).toList().reversed());
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno){
        return ResponseEntity.status(201).body(alumnoService.save(alumno));
    }
}
