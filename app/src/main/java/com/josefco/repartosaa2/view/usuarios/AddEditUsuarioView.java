package com.josefco.repartosaa2.view.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import static com.josefco.repartosaa2.api.Constantes.Action.POST;
import static com.josefco.repartosaa2.api.Constantes.Action.PUT;
import static com.josefco.repartosaa2.api.Constantes.Action;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.usuarios.AddEditUsuarioContract;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.presenter.usuarios.AddEditUsuarioPresenter;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AddEditUsuarioView extends AppCompatActivity implements AddEditUsuarioContract.View, OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private AddEditUsuarioPresenter presenter;

    private GoogleMap map;
    public double latusuario;
    public double lonusuario;
    private boolean contadorMarker = true;
    private String nombreMarker;
    private Action action;
    private Usuario usuario;
    public LatLng ubicacionUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_usuario_view);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        Bundle objetoEnviado = getIntent().getExtras();
        action = Action.valueOf(getIntent().getStringExtra("ACTION"));

        //usuario = null;
        if (objetoEnviado != null && action == PUT) {
            usuario = (Usuario) objetoEnviado.getSerializable("usuario");
            rellenarCampos();
        }

        presenter = new AddEditUsuarioPresenter(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapLongClickListener(this);

        ubicacionUsuario = new LatLng(usuario.getLat(),usuario.getLon());

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

    public void obtenerUsuario(){
        Bundle objetoEnviado = getIntent().getExtras();
        if(objetoEnviado!=null){
            usuario= (Usuario) objetoEnviado.getSerializable("usuario");
        }
    }


    @Override
    public void onMapLongClick(LatLng latLng) {
        while (contadorMarker) {
            map.addMarker(new MarkerOptions()
                    .position(latLng));

            latusuario = latLng.latitude;
            lonusuario = latLng.longitude;

            Geocoder geocoder = new Geocoder(this, Locale.forLanguageTag("ES"));
            try {
                List<Address> listAddress = geocoder.getFromLocation(latusuario, lonusuario, 1);
                if (listAddress.size() > 0) {
                    Toast.makeText(this, "" + listAddress.get(0).getLocality(), Toast.LENGTH_SHORT).show();
                    nombreMarker = listAddress.get(0).getSubAdminArea();
                    System.out.println(" ");
                    System.out.println("calle " + listAddress.get(0).getThoroughfare());
                    System.out.println("localidad " + listAddress.get(0).getLocality());
                    System.out.println("ciudad " + listAddress.get(0).getSubAdminArea());
                    System.out.println("provincia " + listAddress.get(0).getAdminArea());
                    System.out.println("pais " + listAddress.get(0).getCountryName());
                    System.out.println("codigo postal " + listAddress.get(0).getPostalCode());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            contadorMarker = false;
        }
    }


    @Override
    public void addUsuario(View view) {
        EditText etNombre = findViewById(R.id.et_nombre_usuario);
        EditText etApellido = findViewById(R.id.et_apellido_usuario);
        EditText etTelefono = findViewById(R.id.et_telefono_usuario);
        //EditText etDireccion = findViewById(R.id.et_direccion_usuario);

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String telefono = etTelefono.getText().toString();
        //etDireccion.setText(nombreMarker);


        if (action == POST)
            presenter.addUsuario(nombre, apellido, telefono, nombreMarker, latusuario, lonusuario);
        else
            presenter.modifyUsuario(usuario.getId(), nombre, apellido, telefono, nombreMarker, latusuario, lonusuario);
        etNombre.setText("");
        etApellido.setText("");
        etTelefono.setText("");
        //etDireccion.setText("");
        map.clear();
        contadorMarker = true;
    }

    public void resetMarkers(View view) {
        map.clear();
        contadorMarker = true;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void rellenarCampos(){

        obtenerUsuario();
        EditText etNombre = findViewById(R.id.et_nombre_usuario);
        EditText etApellido = findViewById(R.id.et_apellido_usuario);
        EditText etTelefono = findViewById(R.id.et_telefono_usuario);
        //EditText etDireccion = findViewById(R.id.et_direccion_usuario);

        etNombre.setText(usuario.getNombre());
        etApellido.setText(usuario.getApellido());
        etTelefono.setText(usuario.getTelefono());
        //etDireccion.setText(usuario.getDireccion());

    }



}