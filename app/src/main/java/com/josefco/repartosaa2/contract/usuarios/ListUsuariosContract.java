package com.josefco.repartosaa2.contract.usuarios;

import com.josefco.repartosaa2.domain.Usuario;

import java.io.IOException;
import java.util.List;

public interface ListUsuariosContract {

    interface Model {
        //CON RETROFIT
        interface CargarUsuariosListener {
            void CargarUsuariosSuccess(List<Usuario> usuarios);

            void CargarUsuariosError(String message);
        }
        void CargarAllUsuarios(CargarUsuariosListener listener);

//        //CON RXJAVA
//        interface CargarUsuariosRXJListener{
//
//            void CargarUsuariosRXJSuccess(List<Usuario> usuariosrx);
//            void CargarUsuariosRXJError(String message);
//        }
//        void CargarUsuariosRXJ(CargarUsuariosRXJListener listener);

        interface DeleteUsuarioListener {
            void onDeleteUsuarioSuccess(String message);

            void onDeleteUsuarioError(String message);
        }

        void deleteUsuario(String id, DeleteUsuarioListener listener) throws IOException;

    }

    interface View {
        void listarAllUsuarios(List<Usuario> usuarios);
        void showErrorMessage(String message);

    }

    interface Presenter {
        void cargarAllUsuarios();

        void deleteUsuario(String id) throws IOException;
    }
}
