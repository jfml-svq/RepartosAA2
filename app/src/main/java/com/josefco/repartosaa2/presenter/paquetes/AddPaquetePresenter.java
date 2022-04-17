package com.josefco.repartosaa2.presenter.paquetes;

import com.josefco.repartosaa2.contract.paquetes.AddPaqueteContract;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.model.paquetes.AddPaqueteModel;
import com.josefco.repartosaa2.view.paquetes.AddPaqueteView;

public class AddPaquetePresenter implements AddPaqueteContract.Presenter,
        AddPaqueteContract.Model.OnAddPaqueteListener{

    private AddPaqueteModel model;
    private AddPaqueteView view;

    public AddPaquetePresenter(AddPaqueteView view) {
        model = new AddPaqueteModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void onAddPaqueteSuccess(Paquete paquete) {
        view.showMessage("Añadido paquete con id: "+ paquete.getId());
    }

    @Override
    public void onAddPaqueteError(String message) {
        view.showMessage(message);
    }

    @Override
    public void addPaquete(String ancho, String largo, String alto, String peso, String color) {
        Paquete paquete = new Paquete(Integer.parseInt(ancho), Integer.parseInt(largo), Integer.parseInt(alto), Integer.parseInt(peso), color);
        model.addPaquete(paquete,this);
    }
}
