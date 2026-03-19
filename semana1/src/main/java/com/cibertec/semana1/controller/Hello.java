package com.cibertec.semana1.controller;

import com.cibertec.semana1.dto.LoginDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping("/pruebita")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/pruebita2")
    public List<String> hello2() {
        return List.of("Hello World!", "Hola Mundo!", "Cibertec");
    }

    @GetMapping("/pruebita3")
    public List<String> hello3() {
        List<String> nombres = List.of("Miguel", "Angelica", "Gian");
        // Hola Miguel, Hola Angelica, Hola Gian
        // Programacion funcional | Lambda o flechas js
        return nombres.stream() // Flujo de datos o stream
                .map(e -> "Hola " + e) // Transforma y lo retorna
                .toList(); // Lo devuelve en una lista
    }

    @GetMapping("/pruebita4")
    public String hello4(){
        String saludo = "Hola "; // Creando 1 objeto | StringPool
        String nombre = "Miguel"; // Creando 1 objeto | StringPool
        return saludo + nombre; // Creando 1 objeto | StringPool
    }

    @GetMapping("/pruebita5")
    public String hello5(){
        StringBuilder saludo = new StringBuilder("Hola "); // Creando 1 objeto | StringPool
        return saludo.append("Miguel").toString(); // Sigues teniendo 1 solo objeto
    }

    @PostMapping("/pruebita6")
    public String hello6(){
        return "Hola Miguel";
    }

    @PostMapping("/pruebita7")
    public LoginDto hello7(@RequestBody LoginDto loginDto){
        return loginDto;
    }

    @GetMapping("/pruebita8/{valor}") // {valor} es un parametro | datoDinamico
    public String hello8(@PathVariable String valor){
        return valor;
    }

    @GetMapping("/pruebita9")
    public String hello9(@RequestParam String valor){
        return valor;
    }

    @GetMapping("/pruebita10")
    public List<String> hello10(@RequestParam("pepe") String nombre){
        List<String> nombres = List.of("miguel", "angelica", "gian");

        /*return nombres.stream()
                .filter(e -> e.contains(nombre))
                .toList();*/
        List<String> resultado = new ArrayList<>();
        for (String n : nombres) {
            if(n.toLowerCase().startsWith(nombre.toLowerCase())) {
                resultado.add(n);
            }
        }
        return resultado;
    }


}
