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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jose.sisrob.Activitys.Electrico.Codigo_De_Fallas.Consulta;
import com.jose.sisrob.R;


public class Codigo_De_Fallas extends Fragment {

    View view;
    Spinner motor,opcionesdemotor;
    ArrayAdapter<CharSequence> arraymotor;
    ArrayAdapter<CharSequence> [] arrayopcionesdemotor = new  ArrayAdapter[3];
    Button consultar ;
    EditText consulta;
    Integer accion = 0;
    String dato;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_codigo__de__fallas, container, false);

        motor = view.findViewById(R.id.motor);
        opcionesdemotor = view.findViewById(R.id.opciondemotorr);
        consultar = view.findViewById(R.id.tbnconsultar);
        consulta = view.findViewById(R.id.txtdatodeentrada);

            //cargando motores
        arraymotor = ArrayAdapter.createFromResource(getContext(), R.array.motores_array, android.R.layout.simple_spinner_item);
        arraymotor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motor.setAdapter(arraymotor);
        //cargando opciones de motores

        // motor deutz
        arrayopcionesdemotor[0] = ArrayAdapter.createFromResource(getContext(), R.array.opcionesdemotor_deutz_array, android.R.layout.simple_spinner_item);
        arrayopcionesdemotor[0].setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opcionesdemotor.setAdapter(arrayopcionesdemotor[0]);

        //motor perkins
        arrayopcionesdemotor[1] = ArrayAdapter.createFromResource(getContext(), R.array.opcionesdemotor_perkins_array, android.R.layout.simple_spinner_item);
        arrayopcionesdemotor[1].setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //motor cats
        arrayopcionesdemotor[2] = ArrayAdapter.createFromResource(getContext(), R.array.opcionesdemotor_cats_array, android.R.layout.simple_spinner_item);
        arrayopcionesdemotor[2].setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        motor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (i==0){
                    opcionesdemotor.setAdapter(arrayopcionesdemotor[0]);
               }else if (i==1){
                   opcionesdemotor.setAdapter(arrayopcionesdemotor[1]);
               }else if (i==2){
                   opcionesdemotor.setAdapter(arrayopcionesdemotor[2]);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        opcionesdemotor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int intmotor = 1 +motor.getSelectedItemPosition();
                int intselecciondemotor = 1 + opcionesdemotor.getSelectedItemPosition();

                if (intmotor==1 && intselecciondemotor==4){
                    accion=4;
                    String dato = consulta.getText().toString().trim();
                    Intent intent = new Intent(getContext(), Consulta.class);
                    intent.putExtra("accion",accion);
                    intent.putExtra("dato",dato);
                    startActivity(intent);

                }else if (intmotor==1 && intselecciondemotor==3){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getContext());
                    dlgAlert.setMessage("SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                            "\"ACTIVO EN L SIGUIENTE VERSION");
                    dlgAlert.setTitle(getString(R.string.app_name));
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }else if (intmotor==2&&intselecciondemotor==4){
                    accion=8;
                    String dato = consulta.getText().toString().trim();
                    Intent intent = new Intent(getContext(), Consulta.class);
                    intent.putExtra("accion",accion);
                    intent.putExtra("dato",dato);
                    startActivity(intent);
                }else if (intmotor==3&&intselecciondemotor==2){
                    accion=10;
                    String dato = consulta.getText().toString().trim();
                    Intent intent = new Intent(getContext(), Consulta.class);
                    intent.putExtra("accion",accion);
                    intent.putExtra("dato",dato);
                    startActivity(intent);
                }else if (intmotor==3&&intselecciondemotor==3){
                    accion=11;
                    String dato = consulta.getText().toString().trim();
                    Intent intent = new Intent(getContext(), Consulta.class);
                    intent.putExtra("accion",accion);
                    intent.putExtra("dato",dato);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (consulta.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Favor de introducir un dato", Toast.LENGTH_SHORT).show();
                }else {
                    dato= consulta.getText().toString().trim();

                    int intmotor = 1 +motor.getSelectedItemPosition();
                    int intselecciondemotor = 1 + opcionesdemotor.getSelectedItemPosition();

                    if (intmotor==1 && intselecciondemotor==1){accion=1;}
                    if (intmotor==1 && intselecciondemotor==2){accion=2;}
                    if (intmotor==1 && intselecciondemotor==3){accion=3;}
                    if (intmotor==1 && intselecciondemotor==4){accion=4;}
                    if (intmotor==2 && intselecciondemotor==1){accion=5;}
                    if (intmotor==2 && intselecciondemotor==2){accion=6;}
                    if (intmotor==2 && intselecciondemotor==3){accion=7;}
                    if (intmotor==2 && intselecciondemotor==4){accion=8;}
                    if (intmotor==3 && intselecciondemotor==1){accion=9;}
                    if (intmotor==3 && intselecciondemotor==2){accion=10;}
                    if (intmotor==3 && intselecciondemotor==3){accion=11;}


                    Intent intent = new Intent(getContext(), Consulta.class);
                    intent.putExtra("accion",accion);
                    intent.putExtra("dato",dato);
                    startActivity(intent);
                }


            }
        });

        return view;
    }

}
