package com.josefco.repartosaa2.presenter.camiones;

import com.josefco.repartosaa2.contract.camiones.AddEditCamionesContract;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.model.camiones.AddEditCamionesModel;
import com.josefco.repartosaa2.view.camiones.AddEditCamionView;

public class AddEditCamionesPresenter implements
        AddEditCamionesContract.Presenter,
        AddEditCamionesContract.Model.OnAddCamionListener,
        AddEditCamionesContract.Model.OnModifyCamionListener {

    private AddEditCamionesModel model;
    private AddEditCamionView view;

    public AddEditCamionesPresenter(AddEditCamionView view){
        this.view = view;
        model = new AddEditCamionesModel(view.getApplicationContext());
    }


    @Override
    public void onAddCamionSuccess(Camion newCamion) {
        view.showMessage("Camion registrado correctamente");
    }

    @Override
    public void onAddCamionError(String message) {
        view.showMessage("Error");
    }

    @Override
    public void onModifyCamionSuccess(Camion newCamion) {
        view.showMessage("Camion modificado correctamente");
    }

    @Override
    public void onModifyCamionError(String message) {
        view.showMessage("Error");
    }

    @Override
    public void addCamion(String matricula, String marca, String modelo, String gasolina) {
        Camion camion = new Camion(matricula,marca, modelo, Integer.parseInt(gasolina));
        model.addCamion(camion,this);
    }

    @Override
    public void modifyCamion(String id, String matricula, String marca, String modelo, String gasolina) {
        Camion camion = new Camion(matricula, marca, modelo, Integer.parseInt(gasolina));
        model.modifyCamion(id, camion, this);
    }
}
