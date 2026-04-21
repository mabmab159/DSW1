package com.cibertec.semana6.services;

import com.cibertec.semana6.models.Usuario;
import com.cibertec.semana6.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario findByUsernameAndPassword(String username, String password){
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }
}
