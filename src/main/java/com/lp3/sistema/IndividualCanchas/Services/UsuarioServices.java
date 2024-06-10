package com.lp3.sistema.IndividualCanchas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.sistema.IndividualCanchas.Request.usuarioRequest;
import com.lp3.sistema.IndividualCanchas.model.Usuario;
import com.lp3.sistema.IndividualCanchas.repository.UsuarioRepository;

@Service
public class UsuarioServices {
    
    @Autowired
    UsuarioRepository usuarioRepo;

    public void registrarUsuario(usuarioRequest usuario) {
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

    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario getUsuarioById(int idusuario) {
        return usuarioRepo.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void actualizarUsuario(int idusuario, usuarioRequest usuario) {
        Usuario usuarioExistente = getUsuarioById(idusuario);
        usuarioExistente.setDni(usuario.getDni());
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setDireccion(usuario.getDireccion());
        usuarioExistente.setPass(usuario.getPass());
        usuarioExistente.setEstado(usuario.getEstado());
        usuarioRepo.save(usuarioExistente);
    }

    public void eliminarUsuario(int idusuario) {
        Usuario usuarioExistente = getUsuarioById(idusuario);
        usuarioRepo.delete(usuarioExistente);
    }
}
