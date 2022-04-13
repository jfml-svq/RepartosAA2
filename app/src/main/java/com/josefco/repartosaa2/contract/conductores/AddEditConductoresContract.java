package com.josefco.repartosaa2.contract.conductores;

import com.josefco.repartosaa2.domain.Conductor;

public interface AddEditConductoresContract {
    interface Model {
        interface OnAddConductorListener {
            void onAddConductorSuccess(Conductor newConductor);
            void onAddConductorError(String message);
        }
        void addConductor(Conductor Conductor, OnAddConductorListener listener);

        interface OnModifyConductorListener{
            void onModifyConductorSuccess(Conductor newConductor);
            void onModifyConductorError(String message);
        }
        void modifyConductor(String id, Conductor Conductor, OnModifyConductorListener listener);
    }

    interface View {
        void addConductor(android.view.View view);
        void showMessage(String message);
    }

    interface Presenter {
        void addConductor(String nombre, String apellido, String telefono, String direccion);
        void modifyConductor(String id, String nombre, String apellido, String telefono, String direccion);
    }


}
