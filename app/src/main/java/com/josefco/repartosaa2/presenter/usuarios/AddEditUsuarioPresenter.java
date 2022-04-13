package com.josefco.repartosaa2.presenter.usuarios;

import com.josefco.repartosaa2.contract.usuarios.AddEditUsuarioContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.model.usuarios.AddEditUsuarioModel;
import com.josefco.repartosaa2.view.usuarios.AddEditUsuarioView;

public class AddEditUsuarioPresenter
        implements AddEditUsuarioContract.Presenter ,
        AddEditUsuarioContract.Model.OnAddUsuarioListener,
        AddEditUsuarioContract.Model.OnModifyUsuarioListener {

    private AddEditUsuarioModel model;
    private AddEditUsuarioView view;

    public AddEditUsuarioPresenter(AddEditUsuarioView view) {
        this.view = view;
        model = new AddEditUsuarioModel(view.getApplicationContext());
    }
//AÑADIR USUARIO
    @Override
    public void addUsuario(String nombre, String apellido, String telefono, String direccion, double lat, double lon, String email) {
            Usuario usuario = new Usuario(nombre, apellido, telefono, direccion, lat, lon, email);
            model.addUsuario(usuario, this);
    }
    @Override
    public void onAddUsuarioSuccess(Usuario newUsuario) {
        view.showMessage("Usuario insertado");
    }

    @Override
    public void onAddUsuarioError(String message) {
        view.showMessage("Error al insertar usuario");
    }


//MODIFICAR USUARIO
    @Override
    public void modifyUsuario(String id, String nombre, String apellido, String telefono, String direccion, double lat, double lon, String email) {
        Usuario usuario = new Usuario(nombre, apellido, telefono, direccion, lat, lon, email );
        model.modifyUsuario(id, usuario, this);
    }

    @Override
    public void onModifyUsuarioSuccess(Usuario newUsuario) {
                view.showMessage("Usuario modificado");
    }

    @Override
    public void onModifyUsuarioError(String message) {
            view.showMessage("Error al modificar al usuario");
    }
}
