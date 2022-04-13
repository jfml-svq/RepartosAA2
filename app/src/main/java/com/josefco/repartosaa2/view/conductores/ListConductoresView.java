package com.josefco.repartosaa2.view.conductores;

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
import com.josefco.repartosaa2.contract.conductores.ListConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.presenter.conductores.ListConductoresPresenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListConductoresView extends AppCompatActivity
        implements ListConductoresContract.View {

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


    @Override
    protected void onResume() {
        super.onResume();
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

    public void showMessageSuccess(String ok) {
        Toast.makeText(this, ok, Toast.LENGTH_SHORT).show();
    }


    //MENU ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_conductor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addConductor:
                Intent intent = new Intent(this, AddEditConductorView.class);
                intent.putExtra("ACTION","POST");
                startActivity(intent);
                return true;
        }
        return false;
    }



    //MENU CONTEXTUAL USUARIO
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_conductores, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.seeDetailsConductor:
                Conductor conductor = conductoresList.get(position);
                Intent intent = new Intent(this, SeeConductorDetallesView.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("conductor", conductor);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "detalles " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteConductor:
                String id = conductoresList.get(position).getId();
                try {
                    presenter.deleteConductor(id);
                    Toast.makeText(this, "Conductor " + position + " eliminado", Toast.LENGTH_SHORT).show();
                    presenter.cargarAllConductores();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.editConductor:
                conductor = conductoresList.get(position);
                intent = new Intent(this, AddEditConductorView.class);
                bundle = new Bundle();
                bundle.putSerializable("conductor", conductor);
                intent.putExtra("ACTION","PUT");
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "editar " + position, Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }
}