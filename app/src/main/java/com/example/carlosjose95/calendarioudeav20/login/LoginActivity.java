package com.example.carlosjose95.calendarioudeav20.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosjose95.calendarioudeav20.MainActivity;
import com.example.carlosjose95.calendarioudeav20.R;
import com.example.carlosjose95.calendarioudeav20.registro.RegistroActivity;

public class LoginActivity extends AppCompatActivity implements ILoginContract.view {

    private EditText eUsuario, eContraseña;
    private TextView tRegistrarse;
    private Button bIniciar;
    private ILoginContract.presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario = findViewById(R.id.eUsuario);
        eContraseña = findViewById(R.id.eContraseña);
        tRegistrarse = findViewById(R.id.tRegistrarse);
        bIniciar = findViewById(R.id.bIniciar);

        loginPresenter =  new LoginPresenter(this);

        tRegistrarse.setText(Html.fromHtml(getResources().getString(R.string.mensaje)));

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.enviarDatos(eUsuario.getText().toString(),
                        eContraseña.getText().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123 && resultCode == RESULT_OK) {
            finish();
        }

    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mensajeUsuario(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login(String nombre) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("usuario ingresado", nombre);
        startActivityForResult(intent, 123);
    }

}
