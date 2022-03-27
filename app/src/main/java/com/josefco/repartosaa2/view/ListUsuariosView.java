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
import com.josefco.repartosaa2.contract.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.presenter.ListUsuarioPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListUsuariosView extends AppCompatActivity implements
        ListUsuariosContract.View {

    private ListUsuarioPresenter presenter;
    private ArrayAdapter<Usuario> usuariosAdapter;
    private List<Usuario> usuariosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usuarios_view);

        iniciarListaUsuarios();

        presenter = new ListUsuarioPresenter(this);
        presenter.cargarAllUsuarios();

    }

    private void iniciarListaUsuarios() {
        usuariosList = new ArrayList<>();
        usuariosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuariosList);
        ListView lvUsuarios = findViewById(R.id.lvUsuarios);
        lvUsuarios.setAdapter(usuariosAdapter);

        registerForContextMenu(lvUsuarios);

    }



    @Override
    public void listarAllUsuarios(List<Usuario> usuarios) {
        usuariosList.clear();
        usuariosList.addAll(usuarios);
        usuariosAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_usuarios, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.addConductor:
            Toast.makeText(this, "añadir " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteConductor:
                Toast.makeText(this, "borrar " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.editConductor:
                Toast.makeText(this, "editar " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.seeDireccion:
                Toast.makeText(this, "direccion " + position, Toast.LENGTH_SHORT).show();
                return true;
        }

        return true;
    }
}