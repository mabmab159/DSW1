package com.cibertec.semana2.controller;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.service.AlumnoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Alumno> saveAlumno(@RequestBody @Valid Alumno alumno) {
        /*
        if (alumno.getApellido() != null && alumno.getNombre() != null) {
            if (alumno.getApellido().isBlank() || alumno.getNombre().isBlank()) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.status(201).body(alumnoService.save(alumno));
        }
        return ResponseEntity.badRequest().body(null);*/
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

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @Valid @RequestBody Alumno alumno) { //1, {100, "miguel", "berrio"}
        return ResponseEntity.ok(alumnoService.updateAlumnoById(id, alumno));
    }
}
