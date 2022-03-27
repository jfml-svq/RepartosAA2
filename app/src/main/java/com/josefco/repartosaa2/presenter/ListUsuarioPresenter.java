package com.josefco.repartosaa2.presenter;

import com.josefco.repartosaa2.contract.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.model.ListUsuariosModel;
import com.josefco.repartosaa2.view.ListUsuariosView;

import java.util.List;

public class ListUsuarioPresenter implements ListUsuariosContract.Presenter, ListUsuariosContract.Model.CargarUsuariosListener {

    private ListUsuariosModel model;
    private ListUsuariosView view;

    public ListUsuarioPresenter(ListUsuariosView view){
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


}
