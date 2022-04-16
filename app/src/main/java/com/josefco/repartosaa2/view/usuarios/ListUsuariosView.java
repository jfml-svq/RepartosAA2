package com.josefco.repartosaa2.view.usuarios;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.usuarios.ListUsuariosContract;
import com.josefco.repartosaa2.database.AppDatabase;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.domain.UsuarioFav;
import com.josefco.repartosaa2.presenter.usuarios.ListUsuarioPresenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListUsuariosView extends AppCompatActivity implements
        ListUsuariosContract.View {

    private ListUsuarioPresenter presenter;
    private ArrayAdapter<Usuario> usuariosAdapter;
    private List<Usuario> usuariosList;

    List<Usuario> elements;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usuarios_view);


//        init();
        iniciarListaUsuarios();

        presenter = new ListUsuarioPresenter(this);
        presenter.cargarAllUsuarios();

    }

    private void iniciarListaUsuarios() {

        elements = new ArrayList<>();
        listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.rvListUsuarios);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        //registerForContextMenu(recyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.cargarAllUsuarios();
    }

    @Override
    public void listarAllUsuarios(List<Usuario> usuarios) {

        elements.clear();
        elements.addAll(usuarios);
        listAdapter.notifyDataSetChanged();


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
                Intent intent = new Intent(this, AddEditUsuarioView.class);
                intent.putExtra("ACTION", "POST");
                startActivity(intent);
                return true;
            case R.id.listFav:
                intent = new Intent(this, ListUsuarioFavView.class);
                //intent.putExtra("ACTION", "POST");
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

        switch (item.getItemId()) {
            case 0:
                Usuario usuario = elements.get(item.getGroupId());
                Intent intent = new Intent(this, SeeUsuarioDetallesView.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("usuario", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "detalles " + item.getGroupId(), Toast.LENGTH_SHORT).show();
                return true;
            case 1:
                usuario = elements.get(item.getGroupId());
                intent = new Intent(this, AddEditUsuarioView.class);
                bundle = new Bundle();
                bundle.putSerializable("usuario", usuario);
                intent.putExtra("ACTION", "PUT");
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "editar " + item.getGroupId(), Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                String id = elements.get(item.getGroupId()).getId();
                try {
                    presenter.deleteUsuario(id);
                    Toast.makeText(this, "Usuario " + item.getGroupId() + " eliminado", Toast.LENGTH_SHORT).show();
                    presenter.cargarAllUsuarios();
                    listAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case 3:
                usuario = elements.get(item.getGroupId());
                UsuarioFav usuarioFav = new UsuarioFav(usuario.getNombre(),usuario.getApellido(),usuario.getTelefono(),usuario.getTelefono(),usuario.getEmail());
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "repartos").allowMainThreadQueries().build();
                db.usuarioFavDAO().insert(usuarioFav);
                Toast.makeText(this, "Usuario añadido a favoritos!", Toast.LENGTH_SHORT).show();
                return true;

        }
        return true;
    }

    public void showMessageSuccess(String ok) {
        Toast.makeText(this, ok, Toast.LENGTH_SHORT).show();
    }



}