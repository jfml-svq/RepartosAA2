package com.josefco.repartosaa2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.ListConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.presenter.ListConductoresPresenter;
import com.josefco.repartosaa2.presenter.ListUsuarioPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListConductoresView extends AppCompatActivity implements ListConductoresContract.View {

    private ListConductoresPresenter presenter;
    private ArrayAdapter<Conductor> conductoresAdapter;
    private List<Conductor> conductoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_conductores_view);

        iniciarListaConductores();

        presenter = new ListConductoresPresenter(this);
        presenter.cargarAllConductores();
    }

    private void iniciarListaConductores() {
        conductoresList = new ArrayList<>();
        conductoresAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conductoresList);
        ListView lvConductores = findViewById(R.id.lvConductores);
        lvConductores.setAdapter(conductoresAdapter);

        registerForContextMenu(lvConductores);
    }

    @Override
    public void listarAllConductores(List<Conductor> conductores) {
        conductoresList.clear();
        conductoresList.addAll(conductores);
        conductoresAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}