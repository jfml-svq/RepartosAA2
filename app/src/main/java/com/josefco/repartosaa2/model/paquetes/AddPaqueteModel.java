package com.josefco.repartosaa2.model.paquetes;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.paquetes.AddPaqueteContract;
import com.josefco.repartosaa2.domain.Paquete;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPaqueteModel  implements AddPaqueteContract.Model {

    private Context context;

    public AddPaqueteModel(Context context) {
        this.context = context;
    }

    @Override
    public void addPaquete(Paquete paquete, OnAddPaqueteListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Paquete> callPaquete = api.addPaquete(paquete);
        callPaquete.enqueue(new Callback<Paquete>() {
            @Override
            public void onResponse(Call<Paquete> call, Response<Paquete> response) {
                Paquete paquete = response.body();
                listener.onAddPaqueteSuccess(paquete);
            }

            @Override
            public void onFailure(Call<Paquete> call, Throwable t) {
                listener.onAddPaqueteError(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
