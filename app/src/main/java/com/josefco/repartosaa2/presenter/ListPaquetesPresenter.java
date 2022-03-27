package com.josefco.repartosaa2.presenter;

import com.josefco.repartosaa2.contract.ListPaquetesContract;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.model.ListPaquetesModel;
import com.josefco.repartosaa2.model.ListUsuariosModel;
import com.josefco.repartosaa2.view.ListPaquetesView;
import com.josefco.repartosaa2.view.ListUsuariosView;

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
