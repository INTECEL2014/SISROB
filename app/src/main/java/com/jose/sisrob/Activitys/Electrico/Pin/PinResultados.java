package com.jose.sisrob.Activitys.Electrico.Pin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.R;

public class PinResultados extends AppCompatActivity {
    Bundle parametros;
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_resultados);

        pdfView = (PDFView)findViewById(R.id.pdf);
        parametros= this.getIntent().getExtras();

        Integer accion = parametros.getInt("accion",0);

        if (accion==1){
            pdfView.fromAsset("Motor_Deutz_PIN DIAGNOSTICO.pdf").load();
        }else if (accion==2){
            pdfView.fromAsset("CONEXIONE_MOTOR_TCD_2013.pdf").load();
        }else if (accion==3){
            pdfView.fromAsset("pin ecu motor perkins.pdf").load();
        }else  if (accion==4){
            pdfView.fromAsset("conexion de ecu.pdf").load();
        }else if (accion==5){
            Toast.makeText(this, "SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                    "\"ACTIVO EN L SIGUIENTE VERSION", Toast.LENGTH_SHORT).show();
            this.finish();
        }


    }
}
