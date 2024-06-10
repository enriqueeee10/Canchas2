package com.lp3.sistema.IndividualCanchas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.sistema.IndividualCanchas.Request.loginRequest;
import com.lp3.sistema.IndividualCanchas.model.Usuario;
import com.lp3.sistema.IndividualCanchas.repository.UsuarioRepository;

@Service
public class LoginServices {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean validarCredenciales(loginRequest loginRequest) {
        List<Usuario> usuarios = usuarioRepository.findByCorreo(loginRequest.getCorreo());
        return usuarios.stream().anyMatch(usuario -> usuario.getPass().equals(loginRequest.getPass()));
    }
}
