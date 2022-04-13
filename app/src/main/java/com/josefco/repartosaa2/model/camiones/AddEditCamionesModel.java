package com.josefco.repartosaa2.model.camiones;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.camiones.AddEditCamionesContract;
import com.josefco.repartosaa2.domain.Camion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditCamionesModel implements AddEditCamionesContract.Model {

    private Context context;

    public AddEditCamionesModel(Context context){
        this.context = context;
    }
    @Override
    public void addCamion(Camion camion, OnAddCamionListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Camion> callCamion = api.addCamion(camion);
        callCamion.enqueue(new Callback<Camion>() {
            @Override
            public void onResponse(Call<Camion> call, Response<Camion> response) {
                Camion camion = response.body();
                listener.onAddCamionSuccess(camion);
            }

            @Override
            public void onFailure(Call<Camion> call, Throwable t) {
                listener.onAddCamionError("Error");
                t.printStackTrace();
            }
        });

    }

    @Override
    public void modifyCamion(String id, Camion camion, OnModifyCamionListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Camion> callCamion = api.modifyCamion(id, camion);
        callCamion.enqueue(new Callback<Camion>() {
            @Override
            public void onResponse(Call<Camion> call, Response<Camion> response) {
                Camion camion = response.body();
                listener.onModifyCamionSuccess(camion);
            }

            @Override
            public void onFailure(Call<Camion> call, Throwable t) {
                listener.onModifyCamionError("Error");
                t.printStackTrace();
            }
        });
    }
}
