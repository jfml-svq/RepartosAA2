package com.josefco.repartosaa2.model.camiones;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.camiones.ListCamionesContract;
import com.josefco.repartosaa2.contract.conductores.ListConductoresContract;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.util.Mensajes;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCamionesModel implements ListCamionesContract.Model {

    private Context context;

    public ListCamionesModel(Context context) {
        this.context = context;
    }

    @Override
    public void cargarAllCamiones(CargarCamionesListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<List<Camion>> callCamiones = api.getCamiones();
        callCamiones.enqueue(new Callback<List<Camion>>() {
            @Override
            public void onResponse(Call<List<Camion>> call, Response<List<Camion>> response) {
                List<Camion> camiones = response.body();
                listener.CargarCamionesSuccess(camiones);
            }

            @Override
            public void onFailure(Call<List<Camion>> call, Throwable t) {
                    listener.CargarCamionesError(Mensajes.ERROR);
                    t.printStackTrace();
            }
        });
    }

    @Override
    public void deleteCamion(String id, DeleteCamionListener listener) throws IOException {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Void> callCamion = api.deleteCamion(id);
        callCamion.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeleteCamionSuccess(response.message());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeleteCamionError(t.getMessage());
            }
        });
    }


}
