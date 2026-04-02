package com.cibertec.semana3.controller;

import com.cibertec.semana3.dtos.AlumnoRequestDTO;
import com.cibertec.semana3.dtos.AlumnoResponseDTO;
import com.cibertec.semana3.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<AlumnoResponseDTO> createAlumno(@RequestBody @Valid AlumnoRequestDTO alumnoRequestDTO){
        return ResponseEntity.ok(alumnoService.createAlumno(alumnoRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> updateAlumno(@PathVariable Long id, @RequestBody @Valid AlumnoRequestDTO alumnoRequestDTO){
        return ResponseEntity.ok(alumnoService.updateAlumno(id, alumnoRequestDTO));
    }
}
