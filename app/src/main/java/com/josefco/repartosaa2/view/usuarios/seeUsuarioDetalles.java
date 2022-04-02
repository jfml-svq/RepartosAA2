package com.josefco.repartosaa2.view.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.domain.Usuario;

public class seeUsuarioDetalles extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    public double latusuario;
    public double lonusuario;
    public LatLng ubicacionUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_usuario_detalles);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        obtenerUsuario();
    }

    public void obtenerUsuario(){
        TextView tvnombreusuario = findViewById(R.id.tvnombreusuario);
        TextView tvapellidousuario = findViewById(R.id.tvapellidousuario);
        TextView tvtelefonousuario = findViewById(R.id.tvtelefonousuario);
        TextView tvdireccionusuario = findViewById(R.id.tvdireccionusuario);

        Bundle objetoEnviado = getIntent().getExtras();
        Usuario usuario = null;

        if(objetoEnviado!=null){
            usuario= (Usuario) objetoEnviado.getSerializable("usuario");
            tvnombreusuario.setText(usuario.getNombre());
            tvapellidousuario.setText(usuario.getApellido());
            tvtelefonousuario.setText(usuario.getTelefono());
            tvdireccionusuario.setText(String.valueOf(usuario.getDireccion()));

            latusuario = usuario.getLat();
            lonusuario = usuario.getLon();

            ubicacionUsuario = new LatLng(latusuario,lonusuario);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions().position(ubicacionUsuario));
        map.moveCamera(CameraUpdateFactory.newLatLng(ubicacionUsuario));

        // Posiciona la vista del usuario en el punto que se acaba de agregar
        CameraUpdate camara =
                CameraUpdateFactory.newLatLng(ubicacionUsuario);

        // Coloca la vista del mapa sobre la posición del restaurante
        // y activa el zoom para verlo de cerca
        map.moveCamera(camara);
        map.animateCamera(CameraUpdateFactory.zoomTo(8.0f));
    }
}