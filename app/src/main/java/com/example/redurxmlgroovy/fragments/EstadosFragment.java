package com.example.redurxmlgroovy.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.redurxmlgroovy.R;

public class EstadosFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflar el layout del fragment
        View view = inflater.inflate(R.layout.fragment_estados, container, false);
        ListView miListView = view.findViewById(R.id.miListView);

        String[] datos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4",
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, datos);
        miListView.setAdapter(adapter);
        return view;
    }
}
