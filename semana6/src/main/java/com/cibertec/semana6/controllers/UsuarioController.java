package com.cibertec.semana6.controllers;

import com.cibertec.semana6.models.DTO.UsuarioLogin;
import com.cibertec.semana6.models.Usuario;
import com.cibertec.semana6.security.JWTAuthenticationConfig;
import com.cibertec.semana6.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

   private final UsuarioService usuarioService;
   private final JWTAuthenticationConfig jwtAuthenticationConfig;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "Miguel","p", "p","p","p","p", LocalDateTime.now()));
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
        //return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/unprotected")
    public ResponseEntity<List<Usuario>> getUsuariosUnprotected(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "Miguel","p", "p","p","p","p", LocalDateTime.now()));
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
        //return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLogin usuarioLogin){
        Usuario usuario = usuarioService.findByUsernameAndPassword(usuarioLogin.getUsuario(), usuarioLogin.getPassword()); //Buscar mi usuario en la BD
        if(usuario== null){
            throw  new UsernameNotFoundException("Credenciales incorrectas");
        }
        return ResponseEntity.ok(
                jwtAuthenticationConfig.getJWTToken(usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos())
        );
    }
}
