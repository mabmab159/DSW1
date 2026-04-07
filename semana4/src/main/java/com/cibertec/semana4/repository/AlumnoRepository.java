package com.cibertec.semana4.repository;

import com.cibertec.semana4.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findAllByOrderByApellidoDesc();

    @Query("select a from Alumno a ORDER BY a.apellido DESC") //JPQL
    List<Alumno> findAllOrderByApellidoDesc();

    @Query("select a from Alumno a WHERE a.apellido LIKE %:apellido%")
        //Para reemplazar un parametro dentro del query usa :
    List<Alumno> findAllOrderByApellidoContains(String apellido);

    @Query("select a from Alumno a WHERE a.apellido LIKE %:lastName%")
        //Para reemplazar un parametro dentro del query usa :
    List<Alumno> findAllOrderByApellidoContains2(@Param("lastName") String apellido);

    @Procedure(name = "listarAlumnos")
    List<Alumno> findAllAlumnos();

    @Query(value = "select * from Alumno a ORDER IS a.apellido DESC", nativeQuery = true) // SQL
    List<Alumno> findAllOrderByApellidoDesc2();
}
