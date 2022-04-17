package com.josefco.repartosaa2.presenter.usuarios;

import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.domain.UsuarioFav;
import com.josefco.repartosaa2.model.usuarios.ListUsuariosModel;
import com.josefco.repartosaa2.view.usuarios.ListUsuariosView;

import java.io.IOException;
import java.util.List;

public class ListUsuarioPresenter implements
        ListUsuariosContract.Presenter,
        ListUsuariosContract.Model.CargarUsuariosListener,
        //ListUsuariosContract.Model.CargarUsuariosRXJListener,
        ListUsuariosContract.Model.DeleteUsuarioListener {

    private ListUsuariosModel model;
    private ListUsuariosView view;

    public ListUsuarioPresenter(ListUsuariosView view) {
        model = new ListUsuariosModel(view.getApplicationContext());
        this.view = view;
    }

    //ALL USUARIOS retrofit
    @Override
    public void cargarAllUsuarios() {
        model.CargarAllUsuarios(this);
    }

//    //ALL USUARIOS rxjava
//    @Override
//    public void cargarAllUsuarios() {
//        model.CargarUsuariosRXJ(this);
//    }

    @Override
    public void CargarUsuariosSuccess(List<Usuario> usuarios) {
        view.listarAllUsuarios(usuarios);
    }

    @Override
    public void CargarUsuariosError(String message) {
        view.showErrorMessage(message);
    }

    //DELETE USUARIO
    @Override
    public void deleteUsuario(String id) throws IOException {
        model.deleteUsuario(id, this);
    }
    @Override
    public void onDeleteUsuarioSuccess(String message) {
        view.showMessageSuccess(message);
    }

    @Override
    public void onDeleteUsuarioError(String message) {
        view.showErrorMessage(message);
    }

    public void addUsuarioFav(String nombre, String apellido, String telefono, String direccion, String email) {
        model.addUsuarioFav(nombre, apellido, telefono, direccion, email);
    }

//    @Override
//    public void CargarUsuariosRXJSuccess(List<Usuario> usuariosrx) {
//        view.listarAllUsuarios(usuariosrx);
//    }
//
//    @Override
//    public void CargarUsuariosRXJError(String message) {
//        view.showMessageSuccess(message);
//    }
}
