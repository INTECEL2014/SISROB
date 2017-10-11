package com.jose.sisrob.Activitys.Ubicacion_de_Sensores;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.R;

public class Resultados_Ubicacion_de_Sensores extends AppCompatActivity  implements View.OnClickListener{

    LinearLayout contenedor [] = new LinearLayout[3];
    TextView numero[]= new TextView[34];
    String Dato ="q";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados__ubicacion_de__sensores);

        contenedor [0]= (LinearLayout) findViewById(R.id.contenedor116d);
        contenedor [1]= (LinearLayout) findViewById(R.id.contenedortcd2013);
        contenedor [2]= (LinearLayout) findViewById(R.id.contenedorc66);

        Bundle bundle = getIntent().getExtras();
        String ubicacion = bundle.getString("ubicacion").trim();

        Toast.makeText(this, ubicacion, Toast.LENGTH_SHORT).show();


        numero[0] = (TextView)findViewById(R.id.txt1);
        numero[1] = (TextView)findViewById(R.id.txt2);
        numero[2] = (TextView)findViewById(R.id.txt3);
        numero[3] = (TextView)findViewById(R.id.txt4);
        numero[4] = (TextView)findViewById(R.id.txt5);
        numero[5] = (TextView)findViewById(R.id.txt6);
        numero[6] = (TextView)findViewById(R.id.txt7);
        numero[7] = (TextView)findViewById(R.id.txt8);
        numero[8] = (TextView)findViewById(R.id.txt9);
        numero[9] = (TextView)findViewById(R.id.txt11);
        numero[10] = (TextView)findViewById(R.id.txt12);
        numero[11] = (TextView)findViewById(R.id.txt13);
        numero[12] = (TextView)findViewById(R.id.txt14);
        numero[13] = (TextView)findViewById(R.id.txt15);
        numero[14] = (TextView)findViewById(R.id.txt16);
        numero[15] = (TextView)findViewById(R.id.txt17);
        numero[16] = (TextView)findViewById(R.id.txt18);
        numero[17] = (TextView)findViewById(R.id.txt19);
        numero[18] = (TextView)findViewById(R.id.txt20);
        numero[19] = (TextView)findViewById(R.id.txt21);
        numero[20] = (TextView)findViewById(R.id.txt22);
        numero[21] = (TextView)findViewById(R.id.txt23);
        numero[22] = (TextView)findViewById(R.id.txt24);
        numero[23] = (TextView)findViewById(R.id.txt25);
        numero[24] = (TextView)findViewById(R.id.txt26);
        numero[25] = (TextView)findViewById(R.id.txt27);
        numero[26] = (TextView)findViewById(R.id.txt28);
        numero[27] = (TextView)findViewById(R.id.txt29);
        numero[28] = (TextView)findViewById(R.id.txt30);
        numero[29] = (TextView)findViewById(R.id.txt31);
        numero[30] = (TextView)findViewById(R.id.txt32);
        numero[31] = (TextView)findViewById(R.id.txt33);
        numero[32] = (TextView)findViewById(R.id.txt34);
        numero[33] = (TextView)findViewById(R.id.txt35);


        for (int i =0; i<34;i++){
            numero[i].setOnClickListener(this);

        }

        switch (ubicacion){
            case "1106D":
                contenedor[0].setVisibility(View.VISIBLE);
                break;
            case "TCD 2013":
                contenedor[1].setVisibility(View.VISIBLE);
                break;
            case "C6.6":
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
        }



       
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.txt1:
                Dato = "Sensor de temperatura del refrigerante";
                break;
            case R.id.txt2:
                Dato ="Sensor de temperatura  del aire del múltiple de admisión";
                break;
            case R.id.txt3:
                Dato ="Sensor de presión del múltiple de admisión";
                break;
            case R.id.txt4:
                Dato ="Sensor de presión del riel de combustible";
                break;
            case R.id.txt5:
                Dato ="Módulo de Control Electrónico (ECM) (6) Sensor de presión de aceite";
                break;
            case R.id.txt6:
                Dato =" ";
                break;
            case R.id.txt7:
                Dato ="Sensor  primario  de velocidad / Sincronización";
                break;
            case R.id.txt8:
                Dato ="Sensor secundario  de velocidad/ sincronización";
                break;
            case R.id.txt9:
                Dato ="Solenoide  de la bomba del riel de combustible";
                break;

            /// Motor TCD 2013
            case R.id.txt11:
                Dato="Indicador de presión de combustible";
                break;
            case R.id.txt12:
                Dato="Indicador de la temperatura del refrigerante";
                break;
            case R.id.txt13:
                Dato="Indicador de presión del aire de admisión, indicador de la temperatura del aire de admisión TCD 2012/2013 L06";
                break;
            case R.id.txt14:
                Dato="Indicador de presión del aire de admisión, indicador de la temperatura del aire de admisión TCD 2012/2013 L04";
                break;
            case R.id.txt15:
                Dato="Dispositivo de control del motor";
                break;
            case R.id.txt16:
                Dato="Conector central (para el sistema de control del motor)";
                break;
            case R.id.txt17:
                Dato="Transductor de régimen de giro sobre cigüeñal";
                break;
            case R.id.txt18:
                Dato="Transductor de presión rail";
                break;
            case R.id.txt19:
                Dato="Indicador de nivel de aceite lubricante (opcional)";
                break;
            case R.id.txt20:
                Dato="Transmisor de presión de aceite lubricante";
                break;
            case R.id.txt21:
                Dato="Indicador de presión de combustible";
                break;
            case R.id.txt22:
                Dato="Transductor de régimen de giro sobre árbol de levas";
                break;
            case R.id.txt23:
                Dato="Suministro de energía (batería)";
                break;
            case R.id.txt24:
                Dato="Indicador multifunción";
                break;
            case R.id.txt25:
                Dato="Salidas de señal, p.ej., para lámparas, par motor (PWM), régimen de revoluciones, funcionamiento del motor, etcétera.";
                break;
            case R.id.txt26:
                Dato="Entradas (p.ej., tecla de funcionamiento manual)";
                break;
            case R.id.txt27:
                Dato="Pedal acelerador";
                break;
            case R.id.txt28:
                Dato="Acelerador de mano";
                break;
            case R.id.txt29:
                Dato="Conmutador de funciones opcional, p.ej. Para  grado proporcional, tipo de regulador, curvas de inyección,  régimen de giro fijo, etcétera.";
                break;
            case R.id.txt31:
                Dato="";
                break;
            case R.id.txt32:
                Dato="";
                break;
            case R.id.txt33:
                Dato="";
                break;
            case R.id.txt34:
                Dato="";
                break;
            case R.id.txt35:
                Dato="";
                break;

        }
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(Dato);
        dlgAlert.setTitle(getString(R.string.app_name));
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
