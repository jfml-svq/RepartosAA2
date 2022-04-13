package com.josefco.repartosaa2.model.conductores;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.conductores.AddEditConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditConductoresModel implements AddEditConductoresContract.Model {

    private Context context;

    public AddEditConductoresModel(Context context){
        this.context = context;
    }


    @Override
    public void addConductor(Conductor conductor, OnAddConductorListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Conductor> callConductor = api.addConductor(conductor);
        callConductor.enqueue(new Callback<Conductor>() {
            @Override
            public void onResponse(Call<Conductor> call, Response<Conductor> response) {
                Conductor conductor = response.body();
                listener.onAddConductorSuccess(conductor);
            }

            @Override
            public void onFailure(Call<Conductor> call, Throwable t) {
                listener.onAddConductorError("Error");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void modifyConductor(String id, Conductor conductor, OnModifyConductorListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Conductor> call = api.modifyConductor(id, conductor);
        call.enqueue(new Callback<Conductor>() {
            @Override
            public void onResponse(Call<Conductor> call, Response<Conductor> response) {
                Conductor Conductor = response.body();
                listener.onModifyConductorSuccess(Conductor);
            }

            @Override
            public void onFailure(Call<Conductor> call, Throwable t) {
                listener.onModifyConductorError("Error");
            }
        });
    }

}
