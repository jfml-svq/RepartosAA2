package com.josefco.repartosaa2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.view.usuarios.ListUsuariosView;

public class InicioApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void listConductores(View view) {
        Intent intent = new Intent(this, ListConductoresView.class);
        startActivity(intent);

    }

    public void listCamiones(View view) {
        Intent intent = new Intent(this, ListCamionesView.class);
        startActivity(intent);
    }

    public void listUsuarios(View view) {
        Intent intent = new Intent(this, ListUsuariosView.class);
        intent.putExtra("ACCION", "ALL");
        startActivity(intent);
    }



    public void listPaquetes(View view) {
        Intent intent = new Intent(this, ListPaquetesView.class);
        startActivity(intent);

    }
}