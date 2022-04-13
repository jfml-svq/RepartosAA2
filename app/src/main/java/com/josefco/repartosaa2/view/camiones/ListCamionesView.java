package com.josefco.repartosaa2.view.camiones;

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
import com.josefco.repartosaa2.contract.camiones.ListCamionesContract;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.presenter.camiones.ListCamionesPresenter;

import java.io.IOException;
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

    @Override
    protected void onResume() {
        super.onResume();
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

    //MENU ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_camion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addCamion:
                Intent intent = new Intent(this, AddEditCamionView.class);
                intent.putExtra("ACTION","POST");
                startActivity(intent);
                return true;
        }
        return false;
    }


    //MENU CONTEXTUAL
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_camiones, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.seeDetailsCamion:
                Camion camion = camionesList.get(position);
                Intent intent = new Intent(this, SeeCamionDetallesView.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("camion", camion);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "detalles " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteCamion:
                String id = camionesList.get(position).getId();
                try {
                    presenter.deleteCamion(id);
                    Toast.makeText(this, "Camion " + position + " eliminado", Toast.LENGTH_SHORT).show();
                    presenter.cargarAllCamiones();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.editCamion:
                camion = camionesList.get(position);
                intent = new Intent(this, AddEditCamionView.class);
                bundle = new Bundle();
                bundle.putSerializable("camion", camion);
                intent.putExtra("ACTION","PUT");
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "editar " + position, Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

    public void showSuccessMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}