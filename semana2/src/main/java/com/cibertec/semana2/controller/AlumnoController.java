package com.cibertec.semana2.controller;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping("/all")
    public List<Alumno> getAllAlumno() {
        return alumnoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Alumno> saveAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.status(201).body(alumnoService.save(alumno));
    }

    @GetMapping("/{id}")
    public Alumno getAlumnoById(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id);
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<Alumno> getAlumnoById2(@PathVariable Long id) {
        //return ResponseEntity.ok(alumnoService.getAlumnoById(id));
        return new ResponseEntity<>(alumnoService.getAlumnoById(id), HttpStatus.OK);
    }
}
