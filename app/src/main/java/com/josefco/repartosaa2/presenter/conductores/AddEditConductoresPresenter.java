package com.josefco.repartosaa2.presenter.conductores;

import com.josefco.repartosaa2.contract.conductores.AddEditConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.model.conductores.AddEditConductoresModel;
import com.josefco.repartosaa2.view.conductores.AddEditConductorView;

public class AddEditConductoresPresenter
        implements AddEditConductoresContract.Presenter,
        AddEditConductoresContract.Model.OnAddConductorListener,
        AddEditConductoresContract.Model.OnModifyConductorListener{

    private AddEditConductoresModel model;
    private AddEditConductorView view;

    public AddEditConductoresPresenter(AddEditConductorView view){
        this.view = view;
        model = new AddEditConductoresModel(view.getApplicationContext());
    }

    @Override
    public void addConductor(String nombre, String apellido, String telefono, String direccion) {
        Conductor conductor = new Conductor(nombre, apellido, telefono, direccion);
        model.addConductor(conductor, this);
    }

    @Override
    public void onAddConductorSuccess(Conductor newConductor) {
        view.showMessage("Conductor registrado correctamente");
    }

    @Override
    public void onAddConductorError(String message) {
        view.showMessage("Error");
    }

    @Override
    public void onModifyConductorSuccess(Conductor newConductor) {
        view.showMessage("Conductor modificado correctamente");
    }

    @Override
    public void onModifyConductorError(String message) {
        view.showMessage("Error");
    }


    @Override
    public void modifyConductor(String id, String nombre, String apellido, String telefono, String direccion) {
        Conductor conductor = new Conductor(nombre, apellido, telefono, direccion);
        model.modifyConductor(id, conductor,this);
    }

}
