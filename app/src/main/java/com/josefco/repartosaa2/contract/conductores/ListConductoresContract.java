package com.josefco.repartosaa2.contract.conductores;

import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Conductor;

import java.io.IOException;
import java.util.List;

public interface ListConductoresContract {

    interface Model {
        interface CargarConductoresListener {
            void CargarConductoresSuccess(List<Conductor> conductores);

            void CargarConductoresError(String message);
        }

        void CargarAllConductores(CargarConductoresListener listener);

        interface DeleteConductorListener {
            void onDeleteConductorSuccess(String message);

            void onDeleteConductorError(String message);
        }

        void deleteConductor(String id, DeleteConductorListener listener)
                throws IOException;
    }

    interface View {
        void listarAllConductores(List<Conductor> conductores);

        void showErrorMessage(String message);

    }

    interface Presenter {
        void cargarAllConductores();

        void deleteConductor(String id) throws IOException;
    }
}
