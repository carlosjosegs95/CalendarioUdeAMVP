package com.example.carlosjose95.calendarioudeav20.registro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosjose95.calendarioudeav20.CalendarioApp;
import com.example.carlosjose95.calendarioudeav20.persistency.UsuariosSQLiteHelper;

public class RegistroRepository implements IRegistroRepository {

    private IRegistroContract.interactor registroInteractor;

    public RegistroRepository(IRegistroContract.interactor registroInteractor) {
        this.registroInteractor = registroInteractor;
    }

    @Override
    public void guardarDatos(String nombre, String correo, String contraseña) {

        UsuariosSQLiteHelper usuariosSQLiteHelper;
        SQLiteDatabase dbUsuarios;
        ContentValues dataBD;

        usuariosSQLiteHelper = new UsuariosSQLiteHelper(
                CalendarioApp.getmContext(),
                "usuariosBD",
                null,
                1);

        dbUsuarios = usuariosSQLiteHelper.getWritableDatabase();

        Cursor c = dbUsuarios.rawQuery(
                "SELECT * FROM usuarios WHERE nombre = '"+nombre+"'",
                null);

        if(c.moveToFirst()){
            registroInteractor.mensajeUsuario("El usuario ya existe, por favor cambia el nombre");
            dbUsuarios.close();
        } else {
            dataBD = new ContentValues();
            dataBD.put("nombre", nombre);
            dataBD.put("correo", correo);
            dataBD.put("contraseña", contraseña);

            dbUsuarios.insert("usuarios", null, dataBD);
            dbUsuarios.close();

            registroInteractor.mensajeUsuario("Usuario guardado con exito");
            registroInteractor.finalizar();
        }

    }
}
