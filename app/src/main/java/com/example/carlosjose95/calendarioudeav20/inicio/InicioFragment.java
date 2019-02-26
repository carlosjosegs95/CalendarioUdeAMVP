package com.example.carlosjose95.calendarioudeav20.inicio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carlosjose95.calendarioudeav20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private TextView tTitulo;
    private String nombre;

    public InicioFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        tTitulo = view.findViewById(R.id.tTitulo);

        Bundle args = getArguments();

        if(args != null){
            nombre = args.getString("usuario");
            tTitulo.setText("¡ Te damos la bienvenida " + nombre + " !");
        }

        return view;
    }

}
