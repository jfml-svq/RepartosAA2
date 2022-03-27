package com.josefco.repartosaa2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.ListPaquetesContract;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.presenter.ListPaquetesPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListPaquetesView extends AppCompatActivity implements ListPaquetesContract.View {

    private ListPaquetesPresenter presenter;
    private ArrayAdapter<Paquete> paquetesAdapter;
    private List<Paquete> paquetesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_paquetes_view);

        iniciarListaPaquetes();

        presenter = new ListPaquetesPresenter(this);
        presenter.cargarAllPaquetes();
    }

    private void iniciarListaPaquetes() {
        paquetesList = new ArrayList<>();
        paquetesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paquetesList);
        ListView lvpaquetes = findViewById(R.id.lvPaquetes);
        lvpaquetes.setAdapter(paquetesAdapter);

        registerForContextMenu(lvpaquetes);
    }

    @Override
    public void listarAllPaquetes(List<Paquete> paquetes) {
        paquetesList.clear();
        paquetesList.addAll(paquetes);
        paquetesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_paquetes, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.addCamion:
                Toast.makeText(this, "añadir " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteCamion:
                Toast.makeText(this, "borrar " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.editCamion:
                Toast.makeText(this, "editar " + position, Toast.LENGTH_SHORT).show();
                return true;
        }

        return true;
    }
}