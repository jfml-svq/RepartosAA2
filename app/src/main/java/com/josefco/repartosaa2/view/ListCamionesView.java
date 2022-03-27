package com.josefco.repartosaa2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.ListCamionesContract;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.presenter.ListCamionesPresenter;
import com.josefco.repartosaa2.presenter.ListPaquetesPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListCamionesView extends AppCompatActivity implements ListCamionesContract.View {


    private ListCamionesPresenter presenter;
    private ArrayAdapter<Camion> camionesAdapter;
    private List<Camion> camionesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_camiones_view);

        iniciarListaCamiones();

        presenter = new ListCamionesPresenter(this);
        presenter.cargarAllCamiones();

    }

    private void iniciarListaCamiones() {
        camionesList = new ArrayList<>();
        camionesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, camionesList);
        ListView lvcamiones = findViewById(R.id.lvCamiones);
        lvcamiones.setAdapter(camionesAdapter);

        registerForContextMenu(lvcamiones);
    }

    @Override
    public void listarAllCamiones(List<Camion> camiones) {
        camionesList.clear();
        camionesList.addAll(camiones);
        camionesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}