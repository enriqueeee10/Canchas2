package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp3.sistema.IndividualCanchas.Request.loginRequest;
import com.lp3.sistema.IndividualCanchas.model.Usuario;
import com.lp3.sistema.IndividualCanchas.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/ingreso")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody loginRequest loginRequest) {
        List<Usuario> usuarios = usuarioRepository.findByCorreo(loginRequest.getCorreo());
        boolean valid = usuarios.stream().anyMatch(usuario -> usuario.getPass().equals(loginRequest.getPass()));
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("valid", valid);
        
        if (valid) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
