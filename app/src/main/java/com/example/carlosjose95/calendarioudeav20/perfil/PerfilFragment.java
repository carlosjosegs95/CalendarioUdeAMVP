package com.example.carlosjose95.calendarioudeav20.perfil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosjose95.calendarioudeav20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilRepository.view{

    private TextView tNombre, tCorreo;
    private String nombre;
    private IPerfilRepository.repository perfilRepository;

    public PerfilFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        tNombre = view.findViewById(R.id.tNombre);
        tCorreo = view.findViewById(R.id.tCorreo);

        perfilRepository = new PerfilRepository(this);

        Bundle args = getArguments();

        if(args != null){
            nombre = args.getString("usuario");
            perfilRepository.buscarDatos(nombre);
        }

        return view;
    }

    public void escribirDatos(String nombre, String correo) {
        tNombre.setText(nombre);
        tCorreo.setText(correo);
    }

    @Override
    public void mensajeError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT);
    }

}
