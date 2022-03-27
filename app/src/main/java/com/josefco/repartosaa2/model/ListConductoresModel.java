package com.josefco.repartosaa2.model;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.ListConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.util.Mensajes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListConductoresModel implements ListConductoresContract.Model {

    private Context context;
    public ListConductoresModel(Context context){
        this.context = context;
    }

    @Override
    public void CargarAllConductores(CargarConductoresListener listener) {

        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<List<Conductor>> callConductores = api.getConductores();
        callConductores.enqueue(new Callback<List<Conductor>>() {
            @Override
            public void onResponse(Call<List<Conductor>> call, Response<List<Conductor>> response) {
                List<Conductor> conductores = response.body();
                listener.CargarConductoresSuccess(conductores);
            }

            @Override
            public void onFailure(Call<List<Conductor>> call, Throwable t) {
                listener.CargarConductoresError(Mensajes.ERROR);
                t.printStackTrace();
            }
        });

    }
}
