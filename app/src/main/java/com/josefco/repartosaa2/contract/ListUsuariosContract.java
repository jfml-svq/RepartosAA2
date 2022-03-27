package com.josefco.repartosaa2.contract;

import com.josefco.repartosaa2.domain.Usuario;

import java.util.List;

public interface ListUsuariosContract {

    interface Model {
        interface CargarUsuariosListener {
            void CargarUsuariosSuccess(List<Usuario> usuarios);
            void CargarUsuariosError(String message);
        }
        void CargarAllUsuarios(CargarUsuariosListener listener);
    }

    interface View {
        void listarAllUsuarios(List<Usuario> usuarios);
        void showErrorMessage(String message);

    }

    interface Presenter {
        void cargarAllUsuarios();
    }
}
