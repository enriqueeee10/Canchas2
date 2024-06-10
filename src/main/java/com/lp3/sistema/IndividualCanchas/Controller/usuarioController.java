package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lp3.sistema.IndividualCanchas.Request.usuarioRequest;
import com.lp3.sistema.IndividualCanchas.model.Usuario;
import com.lp3.sistema.IndividualCanchas.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @PostMapping("/nuevousuario")
    public void nuevoUsuario(@RequestBody usuarioRequest usuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setDni(usuario.getDni());
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setApellido(usuario.getApellido());
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setTelefono(usuario.getTelefono());
        nuevoUsuario.setDireccion(usuario.getDireccion());
        nuevoUsuario.setPass(usuario.getPass());
        nuevoUsuario.setEstado(usuario.getEstado());



        usuarioRepo.save(nuevoUsuario);
    }

    @GetMapping("/verusuarios")
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @GetMapping("/verusuario/{idusuario}")
    public Usuario getUsuarioid(@PathVariable int idusuario) {
        return usuarioRepo.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @PutMapping("/actualizarusuario/{idusuario}")
    public void actualizarUsuario(@PathVariable int idusuario, @RequestBody usuarioRequest usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepo.findById(idusuario);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setDni(usuario.getDni());
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setTelefono(usuario.getTelefono());
            usuarioExistente.setDireccion(usuario.getDireccion());
            usuarioExistente.setPass(usuario.getPass());
            usuarioExistente.setEstado(usuario.getEstado());


            usuarioRepo.save(usuarioExistente);
        } else {
            // Manejar el caso en que el usuario no exista
        }
    }

    @DeleteMapping("/eliminarusuario/{idusuario}")
    public void eliminarUsuario(@PathVariable int idusuario) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(idusuario);
        if (usuarioOptional.isPresent()) {
            usuarioRepo.deleteById(idusuario);
        } else {
            // Manejar el caso en que el usuario no exista
        }
    }
}
