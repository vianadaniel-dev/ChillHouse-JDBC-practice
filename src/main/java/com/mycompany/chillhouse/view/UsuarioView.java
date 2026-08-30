
package com.mycompany.chillhouse.view;

import com.mycompany.chillhouse.controller.UsuarioController;
import com.mycompany.chillhouse.model.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

//La View recoge datos mediante JOptionPane.

public class UsuarioView {
    private final UsuarioController usuarioController;

    public UsuarioView(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    """
                    1. Registrar usuario
                    2. Listar usuarios
                    3. Buscar usuario
                    4. Eliminar usuario
                    5. Salir
                    """,
                    "Gestión de usuarios",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == null) {
                break;
            }

            try {
                switch (opcion) {
                    case "1" -> registrarUsuario();
                    case "2" -> listarUsuarios();
                    case "3" -> buscarUsuario();
                    case "4" -> eliminarUsuario();
                    case "5" -> continuar = false;
                    default -> mostrarMensaje(
                            "Selecciona una opción válida"
                    );
                }
            } catch (NumberFormatException e) {
                mostrarError("El ID debe ser un número entero");
            } catch (Exception e) {
                mostrarError(e.getMessage());
            }
        }
    }

    private void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog(
                null,
                "Nombre del usuario:"
        );

        if (nombre == null) {
            return;
        }

        String email = JOptionPane.showInputDialog(
                null,
                "Email del usuario:"
        );

        if (email == null) {
            return;
        }

        Usuario usuario =
                usuarioController.registrarUsuario(nombre, email);

        mostrarMensaje(
                """
                Usuario registrado correctamente.
                ID: """ + usuario.getId()
        );
    }

    private void listarUsuarios() {
        List<Usuario> usuarios =
                usuarioController.listarUsuarios();

        if (usuarios.isEmpty()) {
            mostrarMensaje("No hay usuarios registrados");
            return;
        }

        StringBuilder texto = new StringBuilder();

        for (Usuario usuario : usuarios) {
            texto.append("ID: ")
                    .append(usuario.getId())
                    .append("\nNombre: ")
                    .append(usuario.getNombre())
                    .append("\nEmail: ")
                    .append(usuario.getEmail())
                    .append("\n\n");
        }

        mostrarMensaje(texto.toString());
    }

    private void buscarUsuario() {
        String entrada = JOptionPane.showInputDialog(
                null,
                "ID del usuario:"
        );

        if (entrada == null) {
            return;
        }

        int id = Integer.parseInt(entrada);

        usuarioController.buscarUsuario(id)
                .ifPresentOrElse(
                        usuario -> mostrarMensaje(
                                "ID: " + usuario.getId()
                                        + "\nNombre: "
                                        + usuario.getNombre()
                                        + "\nEmail: "
                                        + usuario.getEmail()
                        ),
                        () -> mostrarMensaje(
                                "No se encontró el usuario"
                        )
                );
    }

    private void eliminarUsuario() {
        String entrada = JOptionPane.showInputDialog(
                null,
                "ID del usuario que deseas eliminar:"
        );

        if (entrada == null) {
            return;
        }

        int id = Integer.parseInt(entrada);

        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Seguro que deseas eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            usuarioController.eliminarUsuario(id);
            mostrarMensaje("Usuario eliminado correctamente");
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
