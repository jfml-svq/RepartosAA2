package com.josefco.repartosaa2.view.paquetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.presenter.paquetes.AddPaquetePresenter;

public class AddPaqueteView extends AppCompatActivity {

    private AddPaquetePresenter presenter;

    private Paquete paquete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_paquete_view);

        presenter = new AddPaquetePresenter(this);

    }

    public void addPaquete(View view) {

        EditText etAncho = findViewById(R.id.etAncho);
        EditText etLargo = findViewById(R.id.etLargo);
        EditText etAlto = findViewById(R.id.etAlto);
        EditText etPeso = findViewById(R.id.etPeso);
        EditText etColor = findViewById(R.id.etColor);

        String ancho = etAncho.getText().toString();
        String largo = etLargo.getText().toString();
        String alto = etAlto.getText().toString();
        String peso = etPeso.getText().toString();
        String color = etColor.getText().toString();

        presenter.addPaquete(ancho, largo, alto, peso, color);


        etAncho.setText(" ");
        etLargo.setText(" ");
        etAlto.setText(" ");
        etPeso.setText(" ");
        etColor.setText(" ");

    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}