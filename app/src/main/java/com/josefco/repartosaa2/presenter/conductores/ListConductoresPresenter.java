package com.josefco.repartosaa2.presenter.conductores;

import com.josefco.repartosaa2.contract.conductores.ListConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.model.conductores.ListConductoresModel;
import com.josefco.repartosaa2.view.conductores.ListConductoresView;

import java.io.IOException;
import java.util.List;

public class ListConductoresPresenter implements
        ListConductoresContract.Presenter,
        ListConductoresContract.Model.CargarConductoresListener,
        ListConductoresContract.Model.DeleteConductorListener{

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

    @Override
    public void deleteConductor(String id) throws IOException {
        model.deleteConductor(id, this);
    }

    @Override
    public void onDeleteConductorSuccess(String message) {
        view.showMessageSuccess(message);
    }

    @Override
    public void onDeleteConductorError(String message) {
        view.showErrorMessage(message);
    }
}
