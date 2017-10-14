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

import com.jose.sisrob.Activitys.Bombas_HIdraulicas.Resultados_Bombas_Hidraulicas;
import com.jose.sisrob.Activitys.Dimenciones_De_Mangueras.Resultado_Dimenciones_De_Mangueras;
import com.jose.sisrob.R;


public class Dimenciones_De_Mangueras extends Fragment {

        String[] dimencionesdemangueras  = {"ALPHA 20", "ALPHA 20 AVERHOL", "ALPHA 30","ALPHA 20 TIER 3","TORNADO","TORNADO OVERHOL","TORNADO S2","CST 8.20","COGUARO 4","MIXKRET 4"};
        ListView lista;
        View vista;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         vista = inflater.inflate(R.layout.fragment_dimenciones__de__mangueras, container, false);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), R.layout.lista_planos_electricos, dimencionesdemangueras);
        lista = vista.findViewById(R.id.lista);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if ( i==2|| i==3|| i==6|| i==7|| i== 8){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getContext());
                    dlgAlert.setMessage("SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                            "\"ACTIVO EN L SIGUIENTE VERSION");
                    dlgAlert.setTitle(getString(R.string.app_name));
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }else {
                    String ubicacion = lista.getItemAtPosition(i).toString().trim();
                    Intent intent = new Intent(getContext(),Resultado_Dimenciones_De_Mangueras.class);
                    intent.putExtra("ubicacion",ubicacion);
                    startActivity(intent);
                }
            }
        });
        return vista;
    }


}
