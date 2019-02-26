package com.example.carlosjose95.calendarioudeav20.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosjose95.calendarioudeav20.R;

public class RegistroActivity extends AppCompatActivity implements IRegistroContract.view {

    private EditText eNombre, eCorreo, eContraseña, eRepetir;
    private IRegistroContract.presenter registroPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eNombre = findViewById(R.id.eNombre);
        eCorreo = findViewById(R.id.eCorreo);
        eContraseña = findViewById(R.id.eContraseña);
        eRepetir = findViewById(R.id.eRepetir);

        registroPresenter = new RegistroPresenter(this);
    }

    public void guardar(View view) {
        registroPresenter.enviarDatos(eNombre.getText().toString(),
                eCorreo.getText().toString(),
                eContraseña.getText().toString(),
                eRepetir.getText().toString());
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mensajeUsuario(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finalizar() {
        finish();
    }

    public void regresar(View view) {
        finalizar();
    }
}
