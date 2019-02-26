package com.example.carlosjose95.calendarioudeav20.registro;

public class RegistroInteractor implements IRegistroContract.interactor {

    private IRegistroContract.presenter registroPresenter;
    private IRegistroRepository registroRepository;

    public RegistroInteractor(IRegistroContract.presenter registroPresenter) {
        this.registroPresenter = registroPresenter;
        registroRepository = new RegistroRepository(this);
    }

    @Override
    public void enviarDatos(String nombre, String correo, String contraseña, String rpContraseña) {
        if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || rpContraseña.isEmpty()) {
            registroPresenter.mostrarError("ERROR: Ingrese todos los campos solicitados");
        } else {
            if (contraseña.equals(rpContraseña)) {
                registroRepository.guardarDatos(nombre, correo, contraseña);
            } else {
                registroPresenter.mostrarError("ERROR: Las contraseñas no son iguales");
            }
        }
    }

    @Override
    public void mensajeUsuario(String msg) {
        registroPresenter.mensajeUsuario(msg);
    }

    @Override
    public void finalizar() {
        registroPresenter.finalizar();
    }
}
