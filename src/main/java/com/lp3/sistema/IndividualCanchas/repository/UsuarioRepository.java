package com.lp3.sistema.IndividualCanchas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp3.sistema.IndividualCanchas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByCorreo(String correo);
}
