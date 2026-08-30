
package com.mycompany.chillhouse.service;

import com.mycompany.chillhouse.model.Usuario;
import com.mycompany.chillhouse.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;

//El service contiene las reglas de negocio.


public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(String nombre, String email) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email es obligatorio");
        }

        Usuario usuario = new Usuario(nombre, email);

        return usuarioRepository.guardar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listar();
    }

    public Optional<Usuario> buscarUsuario(int id) {
        return usuarioRepository.buscarPorId(id);
    }
}
