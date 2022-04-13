package com.josefco.repartosaa2.view.camiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.domain.Camion;

public class SeeCamionDetallesView extends AppCompatActivity {

    private Camion camion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_camion_detalles_view);
        obtenerCamion();
    }


    public void obtenerCamion(){
        TextView tvMatricula = findViewById(R.id.tvMatricula);
        TextView tvMarca = findViewById(R.id.tvMarca);
        TextView tvModelo = findViewById(R.id.tvModelo);
        TextView tvGasolina = findViewById(R.id.tvGasolina);

        Bundle objetoEnviado = getIntent().getExtras();

        if (objetoEnviado!=null){
            camion = (Camion) objetoEnviado.getSerializable("camion");
            tvMatricula.setText(camion.getMatricula());
            tvMarca.setText(camion.getMarca());
            tvModelo.setText(camion.getModelo());
            tvGasolina.setText(String.valueOf(camion.getGasolina()));

        }
    }


}