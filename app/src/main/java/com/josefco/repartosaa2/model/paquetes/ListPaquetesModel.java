package com.josefco.repartosaa2.model.paquetes;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.paquetes.ListPaquetesContract;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.util.Mensajes;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPaquetesModel implements ListPaquetesContract.Model {

    private Context context;

    public ListPaquetesModel(Context context) {
        this.context = context;
    }

    @Override
    public void cargarAllPaquetes(ListPaquetesContract.Model.CargarPaquetesListener listener) {

        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<List<Paquete>> callPaquetes = api.getPaquetes();
        callPaquetes.enqueue(new Callback<List<Paquete>>() {
            @Override
            public void onResponse(Call<List<Paquete>> call, Response<List<Paquete>> response) {
                List<Paquete> paquetes = response.body();
                listener.CargarPaquetesSuccess(paquetes);
            }

            @Override
            public void onFailure(Call<List<Paquete>> call, Throwable t) {
                listener.CargarPaquetesError(Mensajes.ERROR);
                t.printStackTrace();
            }
        });

    }

    @Override
    public void deletePaquete(String id, DeletePaqueteListener listener) throws IOException {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Void> callPaquetes = api.deletePaquete(id);
        callPaquetes.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeletePaqueteSuccess(response.message());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeletePaqueteError(t.getMessage());
            }
        });
    }
}
