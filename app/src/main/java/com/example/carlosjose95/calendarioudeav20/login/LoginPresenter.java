package com.example.carlosjose95.calendarioudeav20.login;

public class LoginPresenter implements ILoginContract.presenter {

    private ILoginContract.interactor loginInteractor;
    private ILoginContract.view loginView;

    public LoginPresenter(ILoginContract.view loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractor(this);
    }

    @Override
    public void enviarDatos(String nombre, String contraseña) {
        loginInteractor.enviarDatos(nombre, contraseña);
    }

    @Override
    public void mostrarError(String error) {
        loginView.mostrarError(error);
    }

    @Override
    public void mensajeUsuario(String msg) {
        loginView.mensajeUsuario(msg);
    }

    @Override
    public void login(String nombre) {
        loginView.login(nombre);
    }

}
