package com.jose.sisrob.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.jose.sisrob.Activitys.Ubicacion_de_Sensores.Resultados_Ubicacion_de_Sensores;
import com.jose.sisrob.R;


public class Ubicacion_de_Sensores extends Fragment {


    String[] ubicaciondesensores = {"1106D", "TCD 2013", "C6.6"};
    ListView lista ;
    View vista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       vista = inflater.inflate(R.layout.fragment_ubicacion_de__sensores, container, false);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), R.layout.lista_planos_electricos, ubicaciondesensores);

        lista = vista.findViewById(R.id.listaubicaciondesensores);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==2){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getContext());
                    dlgAlert.setMessage("SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                            "\"ACTIVO EN L SIGUIENTE VERSION");
                    dlgAlert.setTitle(getString(R.string.app_name));
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }else {
                    String ubicacion = lista.getItemAtPosition(i).toString().trim();
                    Intent intent = new Intent(getContext(),Resultados_Ubicacion_de_Sensores.class);
                    intent.putExtra("ubicacion",ubicacion);
                    startActivity(intent);
                }

            }
        });
        return vista;
    }


}
