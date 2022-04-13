package com.josefco.repartosaa2.presenter.camiones;

import com.josefco.repartosaa2.contract.camiones.ListCamionesContract;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.model.camiones.ListCamionesModel;
import com.josefco.repartosaa2.view.camiones.ListCamionesView;

import java.io.IOException;
import java.util.List;

public class ListCamionesPresenter implements ListCamionesContract.Presenter,
        ListCamionesContract.Model.CargarCamionesListener,
        ListCamionesContract.Model.DeleteCamionListener{

    private ListCamionesModel model;
    private ListCamionesView view;

    public ListCamionesPresenter(ListCamionesView view) {
        model = new ListCamionesModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void cargarAllCamiones() {
        model.cargarAllCamiones(this);
    }

    @Override
    public void deleteCamion(String id) throws IOException {
        model.deleteCamion(id, this);
    }

    @Override
    public void CargarCamionesSuccess(List<Camion> camiones) {
        view.listarAllCamiones(camiones);
    }

    @Override
    public void CargarCamionesError(String message) {
        view.showErrorMessage(message);
    }


    @Override
    public void onDeleteCamionSuccess(String message) {
        view.showSuccessMessage(message);
    }

    @Override
    public void onDeleteCamionError(String message) {
        view.showErrorMessage(message);
    }
}
