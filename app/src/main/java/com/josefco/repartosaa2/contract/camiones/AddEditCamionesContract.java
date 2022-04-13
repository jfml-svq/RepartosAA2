package com.josefco.repartosaa2.contract.camiones;

import com.josefco.repartosaa2.domain.Camion;

public interface AddEditCamionesContract {

    interface Model {
        interface OnAddCamionListener {
            void onAddCamionSuccess(Camion newCamion);
            void onAddCamionError(String message);
        }
        void addCamion(Camion camion, OnAddCamionListener listener);

        interface OnModifyCamionListener{
            void onModifyCamionSuccess(Camion newCamion);
            void onModifyCamionError(String message);
        }
        void modifyCamion(String id, Camion Camion, OnModifyCamionListener listener);
    }

    interface View {
        void addCamion(android.view.View view);
        void showMessage(String message);
    }

    interface Presenter {
        void addCamion(String matricula, String marca, String modelo, String gasolina);
        void modifyCamion(String id, String matricula, String marca, String modelo, String gasolina);
    }


}
