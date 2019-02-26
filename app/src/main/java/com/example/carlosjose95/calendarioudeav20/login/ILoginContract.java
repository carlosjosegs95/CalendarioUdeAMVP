package com.example.carlosjose95.calendarioudeav20.login;

public interface ILoginContract {
    interface view {
        void mostrarError(String error);
        void mensajeUsuario(String msg);
        void login(String nombre);
    }

    interface presenter {
        void enviarDatos(String nombre, String contraseña);
        void mostrarError(String error);
        void mensajeUsuario(String msg);
        void login(String nombre);
    }

    interface interactor {
        void enviarDatos(String nombre, String contraseña);
        void mensajeUsuario(String msg);
        void login(String nombre);
    }
}
