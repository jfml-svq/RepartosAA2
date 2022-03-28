package com.josefco.repartosaa2.model.usuarios;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.usuarios.AddUsuarioContract;
import com.josefco.repartosaa2.domain.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUsuarioModel implements AddUsuarioContract.Model {

    private Context context;

    public AddUsuarioModel(Context context){
        this.context = context;
    }


    @Override
    public void addUsuario(Usuario usuario, OnAddUsuarioListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Usuario> callUsuario = api.addUsuario(usuario);
        callUsuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario usuario = response.body();
                listener.onAddUsuarioSuccess(usuario);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                listener.onAddUsuarioError("Error");
                t.printStackTrace();
            }
        });
    }
}
