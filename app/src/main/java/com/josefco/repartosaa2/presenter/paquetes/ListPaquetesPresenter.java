package com.josefco.repartosaa2.presenter.paquetes;

import com.josefco.repartosaa2.contract.paquetes.ListPaquetesContract;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.model.paquetes.ListPaquetesModel;
import com.josefco.repartosaa2.view.paquetes.ListPaquetesView;

import java.util.List;

public class ListPaquetesPresenter implements ListPaquetesContract.Presenter,
        ListPaquetesContract.Model.CargarPaquetesListener {

    private ListPaquetesModel model;
    private ListPaquetesView view;

    public ListPaquetesPresenter(ListPaquetesView view){

        model = new ListPaquetesModel(view.getApplicationContext());
        this.view = view;

    }
    @Override
    public void cargarAllPaquetes() {
        model.cargarAllPaquetes(this);
    }

    @Override
    public void CargarPaquetesSuccess(List<Paquete> paquetes) {
        view.listarAllPaquetes(paquetes);
    }

    @Override
    public void CargarPaquetesError(String message) {
        view.showErrorMessage(message);
    }
}