package com.jose.sisrob.Fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jose.sisrob.Activitys.Planos_Electricos.Resltados_Planos_Electricos;
import com.jose.sisrob.R;
public class PlanosElectricos extends Fragment {

    View vista ;
    String[] sistemas = {"ALPHA 20 ", "ALPHA 20 TIER 3", "ALPHA 30", "TORNADO",  "TORNADO S2"
            , "COUGARO 4", "SPRIT 820", "MIXKRET 4", "ALPHA 20 OVERHOL","TORNADO OVERHOL"};
    ListView lista ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vista =inflater.inflate(R.layout.fragment_planos_electricos, container, false);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), R.layout.lista_planos_electricos, sistemas);
        lista = vista.findViewById(R.id.listaplanoselectricos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String plano = lista.getItemAtPosition(i).toString().trim();

                Intent intent = new Intent(getContext(), Resltados_Planos_Electricos.class);
                intent.putExtra("plano",plano);
                startActivity(intent);
            }
        });

        return vista;
    }


}
