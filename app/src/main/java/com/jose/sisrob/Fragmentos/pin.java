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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.Activitys.Electrico.Pin.PinResultados;
import com.jose.sisrob.R;

public class pin extends Fragment {
    PDFView pdfView;
    Spinner opcion1 ,opcion2;
    View view;
    Integer accion1=-1;
    Button consultar;
    ArrayAdapter<CharSequence> arrayopcion1,arrayopcion2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pin, container, false);

        pdfView = view.findViewById(R.id.pdf);

        opcion1 = view.findViewById(R.id.spiinerpin1);
        opcion2 = view.findViewById(R.id.spinnerpin2);
        consultar = view.findViewById(R.id.btnconsultar);

        arrayopcion1 = ArrayAdapter.createFromResource(getContext(), R.array.opcione1pin, android.R.layout.simple_spinner_item);
        arrayopcion1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        arrayopcion2 = ArrayAdapter.createFromResource(getContext(), R.array.opcione2pin, android.R.layout.simple_spinner_item);
        arrayopcion2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        opcion1.setAdapter(arrayopcion1);
        opcion2.setAdapter(arrayopcion2);

        opcion1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==2){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getContext());
                    dlgAlert.setMessage("SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                            "\"ACTIVO EN L SIGUIENTE VERSION");
                    dlgAlert.setTitle(getString(R.string.app_name));
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            Integer accion =0;
            @Override
            public void onClick(View view) {
                if (opcion1.getSelectedItemPosition()==0 && opcion2.getSelectedItemPosition()==0){
                    accion=1;

                }else if (opcion1.getSelectedItemPosition()==0&& opcion2.getSelectedItemPosition()==1){
                    accion=2;
                }else if (opcion1.getSelectedItemPosition()==1 && opcion2.getSelectedItemPosition()==0){
                    accion=3;
                }else if (opcion1.getSelectedItemPosition()==1 && opcion2.getSelectedItemPosition()==1){
                    accion=4;
                }else if (opcion1.getSelectedItemPosition()==2 ) {
                    accion=5;
                }

                Intent intent = new Intent(getContext(), PinResultados.class);
                intent.putExtra("accion",accion);

                startActivity(intent);
            }
        });
        return view;
    }

}
