package com.example.deyvis.exam02.Vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deyvis.exam02.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendedorFragment extends Fragment {


    public VendedorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vendedor2, container, false);
    }

}
