package com.josefco.repartosaa2.presenter.usuarios;

import com.josefco.repartosaa2.contract.usuarios.AddUsuarioContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.model.usuarios.AddUsuarioModel;
import com.josefco.repartosaa2.view.usuarios.AddUsuarioView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddUsuarioPresenter implements AddUsuarioContract.Presenter ,AddUsuarioContract.Model.OnAddUsuarioListener {

    private AddUsuarioModel model;
    private AddUsuarioView view;

    public AddUsuarioPresenter(AddUsuarioView view) {
        this.view = view;
        model = new AddUsuarioModel(view.getApplicationContext());
    }

    @Override
    public void addUsuario(String nombre, String apellido, String telefono, String direccion, double lat, double lon) {


            Usuario usuario = new Usuario(nombre, apellido, telefono, direccion, lat, lon);
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
}
