package com.example.carlosjose95.calendarioudeav20.login;

public class LoginInteractor implements ILoginContract.interactor {

    private ILoginContract.presenter loginPresenter;
    private ILoginRepository loginRepository;

    public LoginInteractor(ILoginContract.presenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        loginRepository = new LoginRepository(this);
    }

    @Override
    public void enviarDatos(String nombre, String contraseña) {
        if (nombre.isEmpty() || contraseña.isEmpty()){
            loginPresenter.mostrarError("ERROR: Ingrese el usuario y contraseña");
        } else {
            loginRepository.buscarDatos(nombre, contraseña);
        }
    }

    @Override
    public void mensajeUsuario(String msg) {
        loginPresenter.mensajeUsuario(msg);
    }

    @Override
    public void login(String nombre) {
        loginPresenter.login(nombre);
    }
}
