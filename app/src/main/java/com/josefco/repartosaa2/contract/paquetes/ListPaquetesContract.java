package com.josefco.repartosaa2.contract.paquetes;

import com.josefco.repartosaa2.domain.Paquete;

import java.io.IOException;
import java.util.List;

public interface ListPaquetesContract {

    interface Model {
        interface CargarPaquetesListener {
            void CargarPaquetesSuccess(List<Paquete> paquetes);
            void CargarPaquetesError(String message);
        }
        void cargarAllPaquetes(CargarPaquetesListener listener);

        interface DeletePaqueteListener{
            void onDeletePaqueteSuccess(String message);
            void onDeletePaqueteError(String message);
        }

        void deletePaquete(String id, ListPaquetesContract.Model.DeletePaqueteListener listener) throws IOException;
    }

    interface View {
        void listarAllPaquetes(List<Paquete> paquetes);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void cargarAllPaquetes();

        void deletePaquete(String id) throws IOException;
    }
}
