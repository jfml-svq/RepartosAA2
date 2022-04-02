package com.josefco.repartosaa2.presenter.usuarios;

import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.model.usuarios.ListUsuariosModel;
import com.josefco.repartosaa2.view.usuarios.ListUsuariosView;

import java.io.IOException;
import java.util.List;

public class ListUsuarioPresenter implements
        ListUsuariosContract.Presenter,
        ListUsuariosContract.Model.CargarUsuariosListener, ListUsuariosContract.Model.DeleteUsuarioListener {

    private ListUsuariosModel model;
    private ListUsuariosView view;

    public ListUsuarioPresenter(ListUsuariosView view) {
        model = new ListUsuariosModel(view.getApplicationContext());
        this.view = view;
    }

    //ALL USUARIOS
    @Override
    public void cargarAllUsuarios() {
        model.CargarAllUsuarios(this);
    }

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
    public void deleteUsuario(int id) throws IOException {
        model.deleteUsuario(id);
    }


    @Override
    public void onDeleteUsuarioSuccess(int id) {
        view.showMessageSuccess("ok");
    }

    @Override
    public void onDeleteUsuarioError(String message) {
        view.showErrorMessage("ok");
    }
}
