package com.example.carlosjose95.calendarioudeav20.registro;

public class RegistroPresenter implements IRegistroContract.presenter {

    private IRegistroContract.interactor registroInteractor;
    private IRegistroContract.view registroView;

    public RegistroPresenter(IRegistroContract.view registroView) {
        this.registroView = registroView;
        registroInteractor = new RegistroInteractor(this);
    }

    @Override
    public void enviarDatos(String nombre, String correo, String contraseña, String rpContraseña) {
        registroInteractor.enviarDatos(nombre, correo, contraseña, rpContraseña);
    }

    @Override
    public void mostrarError(String error) {
        registroView.mostrarError(error);
    }

    @Override
    public void mensajeUsuario(String msg) {
        registroView.mensajeUsuario(msg);
    }

    @Override
    public void finalizar() {
        registroView.finalizar();
    }
}
