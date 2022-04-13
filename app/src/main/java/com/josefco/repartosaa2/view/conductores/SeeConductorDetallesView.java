package com.josefco.repartosaa2.view.conductores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.domain.Conductor;

public class SeeConductorDetallesView extends AppCompatActivity {

    private Conductor conductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_conductor_detalles);

        obtenerConductor();
    }

    public void obtenerConductor(){
        TextView tvnombreconductor = findViewById(R.id.tvnombreconductor);
        TextView tvapellidoconductor = findViewById(R.id.tvapellidoconductor);
        TextView tvtelefonoconductor = findViewById(R.id.tvtelefonoconductor);
        TextView tvdireccionconductor = findViewById(R.id.tvdireccionconductor);

        Bundle objetoEnviado = getIntent().getExtras();
        //conductor = null;

        if(objetoEnviado!=null){
            conductor= (Conductor) objetoEnviado.getSerializable("conductor");
            tvnombreconductor.setText(conductor.getNombre());
            tvapellidoconductor.setText(conductor.getApellido());
            tvtelefonoconductor.setText(conductor.getTelefono());
            tvdireccionconductor.setText(String.valueOf(conductor.getDireccion()));
        }
    }
}