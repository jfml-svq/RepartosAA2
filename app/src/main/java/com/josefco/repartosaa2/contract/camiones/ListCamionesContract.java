package com.josefco.repartosaa2.contract.camiones;

import com.josefco.repartosaa2.contract.conductores.ListConductoresContract;
import com.josefco.repartosaa2.domain.Camion;

import java.io.IOException;
import java.util.List;

public interface ListCamionesContract {

    interface Model {
        interface CargarCamionesListener {
            void CargarCamionesSuccess(List<Camion> camiones);

            void CargarCamionesError(String message);
        }

        void cargarAllCamiones(ListCamionesContract.Model.CargarCamionesListener listener);

        interface DeleteCamionListener {
            void onDeleteCamionSuccess(String message);

            void onDeleteCamionError(String message);
        }

        void deleteCamion(String id, ListCamionesContract.Model.DeleteCamionListener listener)
                throws IOException;
    }

    interface View {
        void listarAllCamiones(List<Camion> camiones);

        void showErrorMessage(String message);
    }

    interface Presenter {
        void cargarAllCamiones();

        void deleteCamion(String id) throws IOException;
    }
}
