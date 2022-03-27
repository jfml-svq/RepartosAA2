package com.josefco.repartosaa2.api;

import static com.josefco.repartosaa2.api.Constantes.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaquetesApi {

    public static PaquetesApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(PaquetesApiInterface.class);
    }
}
