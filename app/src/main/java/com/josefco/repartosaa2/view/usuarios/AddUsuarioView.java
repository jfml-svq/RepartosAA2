package com.josefco.repartosaa2.view.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.usuarios.AddUsuarioContract;
import com.josefco.repartosaa2.presenter.usuarios.AddUsuarioPresenter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddUsuarioView extends AppCompatActivity implements AddUsuarioContract.View, OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private AddUsuarioPresenter presenter;

    private GoogleMap map;
    public double latusuario;
    public double lonusuario;
    private boolean contadorMarker = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_usuario_view);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        presenter = new AddUsuarioPresenter(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapLongClickListener(this);
    }


    @Override
    public void onMapLongClick(LatLng latLng) {

        while (contadorMarker) {
            map.addMarker(new MarkerOptions()
                    .position(latLng));

            latusuario = latLng.latitude;
            lonusuario = latLng.longitude;

            contadorMarker = false;
        }
    }


    @Override
    public void addUsuario(View view) {
        EditText etNombre = findViewById(R.id.et_nombre_usuario);
        EditText etApellido = findViewById(R.id.et_apellido_usuario);
        EditText etTelefono = findViewById(R.id.et_telefono_usuario);
        EditText etDireccion = findViewById(R.id.et_direccion_usuario);

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String telefono = etTelefono.getText().toString();
        String direccion = etDireccion.getText().toString();
        double lat = latusuario;
        double lon = lonusuario;

        presenter.addUsuario(nombre,apellido,telefono,direccion,lat,lon);
        etNombre.setText("");
        etApellido.setText("");
        etTelefono.setText("");
        etDireccion.setText("");
        map.clear();
        contadorMarker = true;
    }

    public void resetMarkers(View view) {
        map.clear();
        contadorMarker = true;
    }

    @Override
    public void showMessage(String message) {

    }
}