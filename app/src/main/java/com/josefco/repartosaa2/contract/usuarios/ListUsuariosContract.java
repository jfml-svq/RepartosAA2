package com.josefco.repartosaa2.contract.usuarios;

import com.josefco.repartosaa2.domain.Usuario;

import java.io.IOException;
import java.util.List;

public interface ListUsuariosContract {

    interface Model {
        interface CargarUsuariosListener {
            void CargarUsuariosSuccess(List<Usuario> usuarios);

            void CargarUsuariosError(String message);
        }

        void CargarAllUsuarios(CargarUsuariosListener listener);

        interface DeleteUsuarioListener {
            void onDeleteUsuarioSuccess(int id);

            void onDeleteUsuarioError(String message);
        }

        void deleteUsuario(int id) throws IOException;

    }

    interface View {
        void listarAllUsuarios(List<Usuario> usuarios);

        void showErrorMessage(String message);
    }

    interface Presenter {
        void cargarAllUsuarios();

        void deleteUsuario(int id) throws IOException;
    }
}
