package com.josefco.repartosaa2.view.usuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.database.AppDatabase;
import com.josefco.repartosaa2.domain.UsuarioFav;

import java.util.ArrayList;
import java.util.List;

public class ListUsuarioFavView extends AppCompatActivity{

        List<UsuarioFav> elements;
        ListAdapterFav listAdapter;
//    public List<UsuarioFav> usuarios;
//    private ArrayAdapter<UsuarioFav> usuariosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usuario_fav_view);


//        usuarios = new ArrayList<>();
//        ListView lvlistPlayer = findViewById(R.id.listviewFav);
//        usuariosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
//        lvlistPlayer.setAdapter(usuariosAdapter);

        iniciarListaUsuarios();
        cargarUsuariosFavoritos();



    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarUsuariosFavoritos();
    }



//    public void refreshList() {
//        loadUsuarios();
//        usuariosAdapter.notifyDataSetChanged();
//    }
//
//    private void loadUsuarios() {
//        usuarios.clear();
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "repartos").allowMainThreadQueries()
//                .fallbackToDestructiveMigration().build();
//        usuarios.addAll(db.usuarioFavDAO().getAll());
//    }

    private void iniciarListaUsuarios() {

        elements = new ArrayList<>();
        listAdapter = new ListAdapterFav(elements,this);
        RecyclerView recyclerView = findViewById(R.id.rvListUsuariosFav);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void cargarUsuariosFavoritos(){

        elements.clear();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "repartos").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
        elements.addAll(db.usuarioFavDAO().getAll());
        listAdapter.notifyDataSetChanged();

    }

}