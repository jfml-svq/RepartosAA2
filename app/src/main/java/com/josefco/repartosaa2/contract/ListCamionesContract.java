package com.josefco.repartosaa2.contract;

import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.domain.Paquete;

import java.util.List;

public interface ListCamionesContract {

    interface Model {
        interface CargarCamionesListener {
            void CargarCamionesSuccess(List<Camion> camiones);
            void CargarCamionesError(String message);
        }
        void cargarAllCamiones(ListCamionesContract.Model.CargarCamionesListener listener);
    }

    interface View {
        void listarAllCamiones(List<Camion> camiones);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void cargarAllCamiones();
    }
}
