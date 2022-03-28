package com.josefco.repartosaa2.model.usuarios;

import android.content.Context;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.presenter.usuarios.ListUsuarioPresenter;
import com.josefco.repartosaa2.util.Mensajes;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUsuariosModel implements ListUsuariosContract.Model {

    private Context context;

    public ListUsuariosModel(Context context){
        this.context = context;
    }


    @Override
    public void CargarAllUsuarios(CargarUsuariosListener listener) {

        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<List<Usuario>> callUsuarios = api.getUsuarios();
        callUsuarios.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                List<Usuario> usuarios = response.body();
                listener.CargarUsuariosSuccess(usuarios);
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                listener.CargarUsuariosError(Mensajes.ERROR);
                t.printStackTrace();
            }
        });

    }

//    @Override
//    public void deleteUsuario(int id) throws IOException {
//        PaquetesApiInterface api = PaquetesApi.buildInstance();
//        Call<Void> callDeleteUsuario = api.deleteUsuario(id);
//        callDeleteUsuario.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                Void delete = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//
//            }
//        }
//    }

//    public void deleteUsuario(int id, ListUsuarioPresenter listUsuarioPresenter){
//        PaquetesApiInterface api = PaquetesApi.buildInstance();
//        Call<Void> callDeleteUsuario = api.deleteUsuario(id);
//        callDeleteUsuario.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                Void delete = response.body();
//                liste
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//
//            }
//        });
//    }
}
