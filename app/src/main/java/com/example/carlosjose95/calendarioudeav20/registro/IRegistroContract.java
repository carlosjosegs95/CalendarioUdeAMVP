package com.example.carlosjose95.calendarioudeav20.registro;

public interface IRegistroContract {
    interface view {
        void mostrarError(String error);
        void mensajeUsuario(String msg);
        void finalizar();
    }

    interface presenter {
        void enviarDatos(String nombre, String correo, String contraseña, String rpContraseña);
        void mostrarError(String error);
        void mensajeUsuario(String msg);
        void finalizar();
    }

    interface interactor {
        void enviarDatos(String nombre, String correo, String contraseña, String rpContraseña);
        void mensajeUsuario(String msg);
        void finalizar();
    }
}
