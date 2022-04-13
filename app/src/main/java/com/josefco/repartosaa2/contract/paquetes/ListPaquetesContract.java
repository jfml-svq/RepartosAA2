package com.josefco.repartosaa2.contract.paquetes;

import com.josefco.repartosaa2.domain.Paquete;

import java.util.List;

public interface ListPaquetesContract {

    interface Model {
        interface CargarPaquetesListener {
            void CargarPaquetesSuccess(List<Paquete> paquetes);
            void CargarPaquetesError(String message);
        }
        void cargarAllPaquetes(CargarPaquetesListener listener);
    }

    interface View {
        void listarAllPaquetes(List<Paquete> paquetes);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void cargarAllPaquetes();
    }
}
