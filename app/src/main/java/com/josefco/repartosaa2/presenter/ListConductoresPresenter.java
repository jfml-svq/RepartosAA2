package com.josefco.repartosaa2.presenter;

import com.josefco.repartosaa2.contract.ListConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.model.ListConductoresModel;
import com.josefco.repartosaa2.model.ListUsuariosModel;
import com.josefco.repartosaa2.view.ListConductoresView;
import com.josefco.repartosaa2.view.ListUsuariosView;

import java.util.List;

public class ListConductoresPresenter implements
        ListConductoresContract.Presenter,
        ListConductoresContract.Model.CargarConductoresListener {

    private ListConductoresModel model;
    private ListConductoresView view;

    public ListConductoresPresenter(ListConductoresView view){
        model = new ListConductoresModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void cargarAllConductores() {
        model.CargarAllConductores(this);
    }
    @Override
    public void CargarConductoresSuccess(List<Conductor> conductores) {
        view.listarAllConductores(conductores);
    }

    @Override
    public void CargarConductoresError(String message) {
        view.showErrorMessage(message);
    }


}
