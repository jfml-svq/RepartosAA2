package com.josefco.repartosaa2.view.conductores;

import androidx.appcompat.app.AppCompatActivity;

import static com.josefco.repartosaa2.api.Constantes.Action.POST;
import static com.josefco.repartosaa2.api.Constantes.Action.PUT;
import static com.josefco.repartosaa2.api.Constantes.Action;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.conductores.AddEditConductoresContract;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.presenter.conductores.AddEditConductoresPresenter;

public class AddEditConductorView extends AppCompatActivity
        implements AddEditConductoresContract.View {

    private AddEditConductoresPresenter presenter;

    private Action action;
    private Conductor conductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_conductor_view);

        Bundle objetoEnviado = getIntent().getExtras();
        action = Action.valueOf(getIntent().getStringExtra("ACTION"));

        if (objetoEnviado != null && action == PUT) {
            rellenarCampos();
        }

        presenter = new AddEditConductoresPresenter(this);
    }

    public void addConductor(android.view.View view) {
        EditText etnombre = findViewById(R.id.et_nombre_conductor);
        EditText etapellido = findViewById(R.id.et_apellido_conductor);
        EditText ettelefono = findViewById(R.id.et_telefono_conductor);
        EditText etdireccion = findViewById(R.id.et_direccion_conductor);

        String nombre = etnombre.getText().toString();
        String apellido = etapellido.getText().toString();
        String telefono = ettelefono.getText().toString();
        String direccion = etdireccion.getText().toString();

        if (action == POST){
            presenter.addConductor(nombre, apellido, telefono, direccion);
        } else {
            presenter.modifyConductor(conductor.getId(), nombre, apellido, telefono, direccion);
        }

        etnombre.setText(" ");
        etapellido.setText(" ");
        ettelefono.setText(" ");
        etdireccion.setText(" ");
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    private void rellenarCampos() {

        obtenerConductor();
        EditText et_nombre_conductor = findViewById(R.id.et_nombre_conductor);
        EditText et_apellido_conductor = findViewById(R.id.et_apellido_conductor);
        EditText et_telefono_conductor = findViewById(R.id.et_telefono_conductor);
        EditText et_direccion_conductor = findViewById(R.id.et_direccion_conductor);

        et_nombre_conductor.setText(conductor.getNombre());
        et_apellido_conductor.setText(conductor.getApellido());
        et_telefono_conductor.setText(conductor.getTelefono());
        et_direccion_conductor.setText(conductor.getDireccion());
    }

    private void obtenerConductor() {
        Bundle objetoEnviado = getIntent().getExtras();
        if (objetoEnviado != null) {
            conductor = (Conductor) objetoEnviado.getSerializable("conductor");
        }
    }

    public void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void showSuccessMessage(String conductor_modificado_correctamente) {
        Toast.makeText(this, conductor_modificado_correctamente, Toast.LENGTH_SHORT).show();
    }
}