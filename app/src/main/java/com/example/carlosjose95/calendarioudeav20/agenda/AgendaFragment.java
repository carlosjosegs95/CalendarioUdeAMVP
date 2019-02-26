package com.example.carlosjose95.calendarioudeav20.agenda;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlosjose95.calendarioudeav20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgendaFragment extends Fragment {

    public AgendaFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);
        return view;
    }

}
