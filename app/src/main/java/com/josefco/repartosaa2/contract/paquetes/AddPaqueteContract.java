package com.josefco.repartosaa2.contract.paquetes;

import com.josefco.repartosaa2.domain.Paquete;

public interface AddPaqueteContract {


    interface Model{
        interface OnAddPaqueteListener{

            void onAddPaqueteSuccess(Paquete paquete);
            void onAddPaqueteError(String message);
        }

        void addPaquete(Paquete paquete, OnAddPaqueteListener listener);
    }

    interface View{
        void addPaquete(android.view.View view);
        void showMessage(String message);
    }

    interface Presenter  {
        void addPaquete (String ancho, String largo, String alto, String peso, String color);
    }
}
