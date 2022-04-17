package com.josefco.repartosaa2.model.usuarios;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.josefco.repartosaa2.api.PaquetesApi;
import com.josefco.repartosaa2.api.PaquetesApiInterface;
import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.database.AppDatabase;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.domain.UsuarioFav;
import com.josefco.repartosaa2.util.Mensajes;
import com.josefco.repartosaa2.view.usuarios.ListUsuariosView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
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
//    public void CargarUsuariosRXJ(CargarUsuariosRXJListener listener) {
//        PaquetesApiInterface api = PaquetesApi.buildInstance();
//        //Observable<List<Usuario>> usuariosrxj = api.getAllUsuariosRXJ();
//        Observable<List<Usuario>> usuariosrxj = api.getAllUsuariosRXJ().subscribe(new Observer<List<Usuario>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(List<Usuario> value) {
//                listener.CargarUsuariosRXJSuccess();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//
//        //listener.CargarUsuariosRXJSuccess(usuariosrxj);
//        System.out.println(usuariosrxj.toString());
//    }

    @Override
    public void deleteUsuario(String id, DeleteUsuarioListener listener) throws IOException {
        PaquetesApiInterface api = PaquetesApi.buildInstance();
        Call<Void> callDeleteUsuario = api.deleteUsuario(id);
        callDeleteUsuario.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeleteUsuarioSuccess(response.message());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeleteUsuarioError(Mensajes.ERROR);
            }
        });
    }


    public void addUsuarioFav(String nombre, String apellido, String telefono, String direccion, String email) {
        UsuarioFav usuarioFav = new UsuarioFav(nombre,apellido, telefono, direccion, email);
        AppDatabase db = Room.databaseBuilder(context,AppDatabase.class, "repartos").allowMainThreadQueries().build();
        db.usuarioFavDAO().insert(usuarioFav);

    }
}
