package com.josefco.repartosaa2.api;

import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.domain.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PaquetesApiInterface {
    //USUARIOS
    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();
    // TODO
    @GET("usuario/{id}")
    Call<Usuario> getUsuario(@Path("id") int id);
    @POST("usuarios")
    Call<Usuario> addUsuario(@Body Usuario usuario);
    // TODO
    @DELETE("usuario/{id}")
    Call<Void> deleteUsuario(@Path("id") int id);
    @PUT("usuario/{id}")
    Call<Usuario> modifyUsuario(@Path("id") int id, @Body Usuario usuario);

    //PAQUETES
    @GET("paquetes")
    Call<List<Paquete>> getPaquetes();
    // TODO
    @GET("paquete/{id}")
    Call<Paquete> getPaquete(@Path("id") int id);
    @POST("paquetes")
    Call<Paquete> addPaquete(@Body Paquete paquete);
    // TODO
    @DELETE("paquete/{id}")
    Call<Void> deletePaquete(@Path("id") int id);
    @PUT("paquete/{id}")
    Call<Paquete> modifyPaquete(@Path("id") int id, @Body Paquete paquete);

    //CAMIONES
    @GET("camiones")
    Call<List<Camion>> getCamiones();
    // TODO
    @GET("camion/{id}")
    Call<Camion> getCamion(@Path("id") int id);
    @POST("camiones")
    Call<Camion> addCamion(@Body Camion camion);
    // TODO
    @DELETE("camion/{id}")
    Call<Void> deleteCamion(@Path("id") int id);
    @PUT("camion/{id}")
    Call<Camion> modifyCamion(@Path("id") int id, @Body Camion camion);

    //CONDUCTORES
    @GET("conductores")
    Call<List<Conductor>> getConductores();
    // TODO
    @GET("conductor/{id}")
    Call<Conductor> getConductor(@Path("id") int id);
    @POST("conductores")
    Call<Conductor> addConductor(@Body Conductor conductor);
    // TODO
    @DELETE("conductor/{id}")
    Call<Void> deleteConductor(@Path("id") int id);
    @PUT("conductor/{id}")
    Call<Conductor> modifyConductor(@Path("id") int id, @Body Conductor conductor);
}
