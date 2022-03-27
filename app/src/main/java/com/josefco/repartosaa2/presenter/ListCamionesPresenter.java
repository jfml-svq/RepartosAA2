package com.josefco.repartosaa2.presenter;

import com.josefco.repartosaa2.contract.ListCamionesContract;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.model.ListCamionesModel;
import com.josefco.repartosaa2.view.ListCamionesView;

import java.util.List;

public class ListCamionesPresenter implements ListCamionesContract.Presenter,
        ListCamionesContract.Model.CargarCamionesListener {

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
    public void CargarCamionesSuccess(List<Camion> camiones) {
        view.listarAllCamiones(camiones);
    }

    @Override
    public void CargarCamionesError(String message) {
        view.showErrorMessage(message);
    }


}
