package com.jose.sisrob.Fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jose.sisrob.Activitys.Bombas_HIdraulicas.Resultados_Bombas_Hidraulicas;
import com.jose.sisrob.Activitys.Ubicacion_de_Sensores.Resultados_Ubicacion_de_Sensores;
import com.jose.sisrob.R;



public class Bombas_Hidraulicas extends Fragment {

    String[] ubicaciondesensores = {"ALPHA 20", "ALPHA 20 AVERHOL", "ALPHA 30","ALPHA 20 TIER 3","TORNADO","TORNADO OVERHOL","TORNADO S2","CST 8.20","COGUARO 4","MIXKRET 4"};
    ListView lista ;
    View vista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_bombas__hidraulicas, container, false);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), R.layout.lista_planos_electricos, ubicaciondesensores);

        lista = vista.findViewById(R.id.lista);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if ( i==1|| i== 2|| i==3|| i==5|| i== 7){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getContext());
                    dlgAlert.setMessage("SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                            "\"ACTIVO EN L SIGUIENTE VERSION");
                    dlgAlert.setTitle(getString(R.string.app_name));
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }else {
                    String ubicacion = lista.getItemAtPosition(i).toString().trim();
                    Intent intent = new Intent(getContext(),Resultados_Bombas_Hidraulicas.class);
                    intent.putExtra("ubicacion",ubicacion);
                    startActivity(intent);
                }
            }
        });




        return vista;
    }


}
