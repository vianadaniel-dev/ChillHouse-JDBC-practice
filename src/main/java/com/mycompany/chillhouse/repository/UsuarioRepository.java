package com.mycompany.chillhouse.repository;

import com.mycompany.chillhouse.model.Usuario;
import java.util.List;
import java.util.Optional;


//Esta capa se encargara unicamente del acceso a la base de datos

public interface UsuarioRepository {
    Usuario guardar(Usuario usuario);

    List<Usuario> listar();

    Optional<Usuario> buscarPorId(int id);

    void eliminar(int id);
}
