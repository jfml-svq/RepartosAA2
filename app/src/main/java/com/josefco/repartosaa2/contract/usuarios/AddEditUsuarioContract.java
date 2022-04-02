package com.josefco.repartosaa2.contract.usuarios;

import com.josefco.repartosaa2.domain.Usuario;


public interface AddEditUsuarioContract {
    interface Model {
        interface OnAddUsuarioListener {
            void onAddUsuarioSuccess(Usuario newUsuario);
            void onAddUsuarioError(String message);
        }
        void addUsuario(Usuario usuario, OnAddUsuarioListener listener);

        interface OnModifyUsuarioListener{
            void onModifyUsuarioSuccess(Usuario newUsuario);
            void onModifyUsuarioError(String message);
        }
        void modifyUsuario(int id, Usuario usuario, OnModifyUsuarioListener listener);
    }

    interface View {
        void addUsuario(android.view.View view);
        void showMessage(String message);
    }

    interface Presenter {
        void addUsuario(String nombre, String apellido, String telefono, String direccion, double lat, double lon);
        void modifyUsuario(int id, String nombre, String apellido, String telefono, String direccion, double lat, double lon);
    }
}
