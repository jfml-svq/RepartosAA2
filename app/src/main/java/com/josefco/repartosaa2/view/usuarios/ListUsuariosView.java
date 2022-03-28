package com.josefco.repartosaa2.view.usuarios;


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
import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.presenter.usuarios.ListUsuarioPresenter;

import java.io.IOException;
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


    //MENU ACTION BAR

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_usuarios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addUsuario:
                Intent intent = new Intent(this, AddUsuarioView.class);
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
        getMenuInflater().inflate(R.menu.context_usuarios, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.seeDetailsUsers:
                Usuario usuario = usuariosList.get(position);
                Intent intent = new Intent(this, seeUsuarioDetalles.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("usuario", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "detalles " + position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteUsuario:
//                int id_usuario = usuariosList.get(position).getId();
//                try {
//                    presenter.deleteUsuario(id_usuario);
//                    refreshList();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
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

    public void showMessageSuccess(String ok) {
    }

    public void refreshList() {
        usuariosAdapter.notifyDataSetChanged();
    }
}