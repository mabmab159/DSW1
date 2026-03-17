package com.cibertec.semana1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/pruebita")
    public String hello(){
        return "Hello World!";
    }
}
