package com.josefco.repartosaa2.contract.usuarios;

import com.josefco.repartosaa2.domain.Usuario;


public interface AddUsuarioContract {
    interface Model {
        interface OnAddUsuarioListener {
            void onAddUsuarioSuccess(Usuario newUsuario);

            void onAddUsuarioError(String message);
        }

        void addUsuario(Usuario usuario, OnAddUsuarioListener listener);
    }

    interface View {
        void addUsuario(android.view.View view);
        void showMessage(String message);
    }

    interface Presenter {
        void addUsuario(String nombre, String apellido, String telefono, String direccion, double lat, double lon);
    }
}
