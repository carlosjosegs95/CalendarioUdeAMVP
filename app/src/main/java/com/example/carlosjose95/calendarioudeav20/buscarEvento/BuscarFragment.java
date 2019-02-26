package com.example.carlosjose95.calendarioudeav20.buscarEvento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlosjose95.calendarioudeav20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment {

    public BuscarFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_buscar, container, false);
        return view;
    }

}
