package com.example.carlosjose95.calendarioudeav20.perfil;

public interface IPerfilRepository {
    interface view {
        void escribirDatos(String nombre, String contraseña);
        void mensajeError(String error);
    }
    interface repository {
        void buscarDatos(String nombre);
    }
}
