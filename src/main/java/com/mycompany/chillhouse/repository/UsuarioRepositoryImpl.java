package com.mycompany.chillhouse.repository;

import com.mycompany.chillhouse.config.DataBaseConnection;
import com.mycompany.chillhouse.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public Usuario guardar(Usuario usuario) {
        String sql = """
                INSERT INTO usuarios (nombre, email)
                VALUES (?, ?)
                RETURNING id
                """;

        try (
                Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement
                = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
            }

            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el usuario", e);
        }
    }

    @Override
    public List<Usuario> listar() {
        String sql = "SELECT id, nombre, email FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (
                Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement
                = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email")
                );

                usuarios.add(usuario);
            }

            return usuarios;

        } catch (SQLException e) {
            throw new RuntimeException("Error al listar usuarios", e);
        }
    }

    @Override
    public Optional<Usuario> buscarPorId(int id) {
        String sql = """
                SELECT id, nombre, email
                FROM usuarios
                WHERE id = ?
                """;

        try (
                Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement
                = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email")
                );

                return Optional.of(usuario);
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario", e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (
                Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement
                = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el usuario", e);
        }
    }
}
