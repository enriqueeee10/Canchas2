package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lp3.sistema.IndividualCanchas.Request.usuarioRequest;
import com.lp3.sistema.IndividualCanchas.Services.UsuarioServices;
import com.lp3.sistema.IndividualCanchas.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class usuarioController {
    
    @Autowired
    UsuarioServices usuarioServices;

    @PostMapping("/nuevousuario")
    public void nuevoUsuario(@RequestBody usuarioRequest usuario) {
        usuarioServices.registrarUsuario(usuario);
    }

    @GetMapping("/verusuarios")
    public List<Usuario> getUsuarios() {
        return usuarioServices.getUsuarios();
    }

    @GetMapping("/verusuario/{idusuario}")
    public Usuario getUsuarioid(@PathVariable int idusuario) {
        return usuarioServices.getUsuarioById(idusuario);
    }

    @PutMapping("/actualizarusuario/{idusuario}")
    public void actualizarUsuario(@PathVariable int idusuario, @RequestBody usuarioRequest usuario) {
        usuarioServices.actualizarUsuario(idusuario, usuario);
    }

    @DeleteMapping("/eliminarusuario/{idusuario}")
    public void eliminarUsuario(@PathVariable int idusuario) {
        usuarioServices.eliminarUsuario(idusuario);
    }
}
