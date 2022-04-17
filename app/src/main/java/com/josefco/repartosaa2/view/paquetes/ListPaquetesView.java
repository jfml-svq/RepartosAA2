package com.josefco.repartosaa2.view.paquetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.paquetes.ListPaquetesContract;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.presenter.paquetes.ListPaquetesPresenter;
import com.josefco.repartosaa2.view.camiones.AddEditCamionView;

import java.io.IOException;
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

    @Override
    protected void onResume() {
        super.onResume();
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


    //MENU ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_paquete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addPaquete:
                Intent intent = new Intent(this, AddPaqueteView.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    //MENU CONTEXTUAL
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
            case R.id.editPaquete:
                Toast.makeText(this, "editar TODO " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.seeRoute:
                Toast.makeText(this, "ruta TODO " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deletePaquete:
                String id = paquetesList.get(position).getId();
                try{
                    presenter.deletePaquete(id);
                    Toast.makeText(this, "Paquete " + position + " eliminado", Toast.LENGTH_SHORT).show();
                    presenter.cargarAllPaquetes();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
        }
        return true;
    }

    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}