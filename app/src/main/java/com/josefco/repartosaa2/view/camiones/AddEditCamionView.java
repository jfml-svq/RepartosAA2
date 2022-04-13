package com.josefco.repartosaa2.view.camiones;

import static com.josefco.repartosaa2.api.Constantes.Action.PUT;
import static com.josefco.repartosaa2.api.Constantes.Action.POST;
import static com.josefco.repartosaa2.api.Constantes.Action;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.api.Constantes;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.presenter.camiones.AddEditCamionesPresenter;

public class AddEditCamionView extends AppCompatActivity {
    
    private AddEditCamionesPresenter presenter;

    private Action action;
    private Camion camion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_camion_view);

        Bundle objetoEnviado = getIntent().getExtras();
        action = Constantes.Action.valueOf(getIntent().getStringExtra("ACTION"));

        if (objetoEnviado != null && action == PUT) {
            rellenarCampos();
        }

        presenter = new AddEditCamionesPresenter(this);
    }

    public void addCamion(android.view.View view) {
        EditText etMatricula = findViewById(R.id.etMatricula);
        EditText etMarca = findViewById(R.id.etMarca);
        EditText etModelo = findViewById(R.id.etModelo);
        EditText etGasolina = findViewById(R.id.etGasolina);

        String matricula = etMatricula.getText().toString();
        String marca = etMarca.getText().toString();
        String modelo = etModelo.getText().toString();
        String gasolina = etGasolina.getText().toString();


        if (action == POST){
            presenter.addCamion(matricula, marca, modelo, gasolina);
        } else {
            presenter.modifyCamion(camion.getId(), matricula, marca, modelo, gasolina);
        }

        etMatricula.setText(" ");
        etMarca.setText(" ");
        etModelo.setText(" ");
        etGasolina.setText(" ");
    }

    private void rellenarCampos() {

        EditText etMatricula = findViewById(R.id.etMatricula);
        EditText etMarca = findViewById(R.id.etMarca);
        EditText etModelo = findViewById(R.id.etModelo);
        EditText etGasolina = findViewById(R.id.etGasolina);

        etMatricula.setText(camion.getMatricula());
        etMarca.setText(camion.getMarca());
        etModelo.setText(camion.getModelo());
        etGasolina.setText(camion.getGasolina());
    }

    private void obtenerCamion() {
        Bundle objetoEnviado = getIntent().getExtras();
        if (objetoEnviado != null) {
            camion = (Camion) objetoEnviado.getSerializable("camion");
        }
    }

    public void showMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}