package com.example.carlosjose95.calendarioudeav20.login;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosjose95.calendarioudeav20.CalendarioApp;
import com.example.carlosjose95.calendarioudeav20.persistency.UsuariosSQLiteHelper;

public class LoginRepository implements ILoginRepository{

    private ILoginContract.interactor loginInteractor;

    public LoginRepository(ILoginContract.interactor loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void buscarDatos(String nombre, String contraseña) {

        UsuariosSQLiteHelper usuariosSQLiteHelper;
        SQLiteDatabase dbUsuarios;

        usuariosSQLiteHelper = new UsuariosSQLiteHelper(
                CalendarioApp.getmContext(),
                "usuariosBD",
                null,
                1);

        dbUsuarios = usuariosSQLiteHelper.getReadableDatabase();

        Cursor cursor1 = dbUsuarios.rawQuery(
                "SELECT * FROM usuarios WHERE nombre = '"+nombre+"'",
                null);

        if(cursor1.moveToFirst()){
            if (cursor1.getString(3).equals(contraseña)) {
                loginInteractor.login(nombre);
            } else {
                loginInteractor.mensajeUsuario("Usuario o contraseña incorrectos");
            }
        } else {
            loginInteractor.mensajeUsuario("Usuario o contraseña incorrectos");
        }
    }
}
