package com.example.carlosjose95.calendarioudeav20.perfil;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosjose95.calendarioudeav20.CalendarioApp;
import com.example.carlosjose95.calendarioudeav20.persistency.UsuariosSQLiteHelper;

public class PerfilRepository implements IPerfilRepository.repository {

    private IPerfilRepository.view perfilView;

    public PerfilRepository(IPerfilRepository.view perfilView) {
        this.perfilView = perfilView;
    }

    @Override
    public void buscarDatos(String nombre) {
        UsuariosSQLiteHelper usuariosSQLiteHelper;
        SQLiteDatabase dbUsuarios;

        usuariosSQLiteHelper = new UsuariosSQLiteHelper(
                CalendarioApp.getmContext(),
                "usuariosBD",
                null,
                1);

        dbUsuarios = usuariosSQLiteHelper.getReadableDatabase();

        Cursor cursor = dbUsuarios.rawQuery(
                "SELECT * FROM usuarios WHERE nombre = '"+nombre+"'",
                null);

        if (cursor.moveToFirst()) {
            perfilView.escribirDatos(nombre, cursor.getString(2));
        } else {
            perfilView.mensajeError("No se ha podido cargar la información");
        }
    }
}
