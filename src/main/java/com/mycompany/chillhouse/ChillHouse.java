package com.mycompany.chillhouse;

import com.mycompany.chillhouse.model.Usuario;
import com.mycompany.chillhouse.repository.UsuarioRepository;
import com.mycompany.chillhouse.repository.UsuarioRepositoryImpl;
import com.mycompany.chillhouse.service.UsuarioService;


public class ChillHouse {

    public static void main(String[] args) {
        UsuarioRepository repository = new UsuarioRepositoryImpl();

        UsuarioService service = new UsuarioService(repository);

        Usuario usuario = service.registrarUsuario(
                "Daniel Viana",
                "Daniel@example.com"
        );

        System.out.println("Usuario creado con ID: " + usuario.getId());

        service.listarUsuarios()
                .forEach(u ->
                        System.out.println(
                                u.getId() + " - " +
                                u.getNombre() + " - " +
                                u.getEmail()
                        )
                );
    }
    }

