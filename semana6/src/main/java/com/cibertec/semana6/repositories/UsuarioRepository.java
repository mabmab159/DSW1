package com.cibertec.semana6.repositories;

import com.cibertec.semana6.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("Select a From Usuario a where a.usuario = :username and a.password = :password")
    Usuario findByUsernameAndPassword(String username, String password);
}
