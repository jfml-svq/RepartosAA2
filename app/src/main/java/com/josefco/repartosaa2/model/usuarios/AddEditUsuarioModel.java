package com.josefco.repartosaa2.model.usuarios;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.usuarios.AddEditUsuarioContract;
import com.josefco.repartosaa2.domain.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditUsuarioModel implements AddEditUsuarioContract.Model {

    private Context context;

    public AddEditUsuarioModel(Context context){
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

    @Override
    public void modifyUsuario(int id, Usuario usuario, OnModifyUsuarioListener listener) {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Usuario> call = api.modifyUsuario(id, usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario usuario = response.body();
                listener.onModifyUsuarioSuccess(usuario);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                listener.onModifyUsuarioError("Error");
            }
        });
    }


}
