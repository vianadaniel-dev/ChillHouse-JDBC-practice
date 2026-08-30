package com.mycompany.chillhouse;

import com.mycompany.chillhouse.controller.UsuarioController;
import com.mycompany.chillhouse.repository.UsuarioRepository;
import com.mycompany.chillhouse.repository.UsuarioRepositoryImpl;
import com.mycompany.chillhouse.service.UsuarioService;
import com.mycompany.chillhouse.view.UsuarioView;


public class ChillHouse {

    public static void main(String[] args) {
        UsuarioRepository repository =
                new UsuarioRepositoryImpl();

        UsuarioService service =
                new UsuarioService(repository);

        UsuarioController controller =
                new UsuarioController(service);

        UsuarioView view =
                new UsuarioView(controller);

        view.iniciar();
    }
    }

