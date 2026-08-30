
package com.mycompany.chillhouse.controller;

import com.mycompany.chillhouse.model.Usuario;
import com.mycompany.chillhouse.service.UsuarioService;
import java.util.List;
import java.util.Optional;

//El Controller actúa como intermediario:
public class UsuarioController {
     private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario registrarUsuario(String nombre, String email) {
        return usuarioService.registrarUsuario(nombre, email);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    public Optional<Usuario> buscarUsuario(int id) {
        return usuarioService.buscarUsuario(id);
    }

    public void eliminarUsuario(int id) {
        usuarioService.eliminarUsuario(id);
    }
}
