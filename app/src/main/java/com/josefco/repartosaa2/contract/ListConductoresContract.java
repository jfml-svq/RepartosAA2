package com.josefco.repartosaa2.contract;

import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.domain.Usuario;

import java.util.List;

public interface ListConductoresContract {

    interface Model {
        interface CargarConductoresListener {
            void CargarConductoresSuccess(List<Conductor> conductores);
            void CargarConductoresError(String message);
        }
        void CargarAllConductores(ListConductoresContract.Model.CargarConductoresListener listener);
    }

    interface View {
        void listarAllConductores(List<Conductor> conductores);
        void showErrorMessage(String message);

    }

    interface Presenter {
        void cargarAllConductores();
    }
}
