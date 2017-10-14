package com.jose.sisrob.Activitys.Dimenciones_De_Mangueras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.R;

public class Resultado_Dimenciones_De_Mangueras extends AppCompatActivity {
    String pdf = "";
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado__dimenciones__de__mangueras);


        pdfView = (PDFView)findViewById(R.id.pdfdimencionesdemangueras);

        Bundle bundle = getIntent().getExtras();
        String ubicacion = bundle.getString("ubicacion").trim();
        Toast.makeText(this, ubicacion, Toast.LENGTH_SHORT).show();

    //   ubicacion="/bombashidraulicas"+ubicacion;

        switch (ubicacion){
            case "ALPHA 20 AVERHOL":
                pdf=ubicacion+"d.pdf";
                break;
            case "ALPHA 20":
                pdf=ubicacion+"d.pdf";
                break;
            case "MIXKRET 4":
                pdf=ubicacion+"d.pdf";
                break;
            case "TORNADO":
                pdf=ubicacion+"d.pdf";
                break;
            case "TORNADO OVERHOL":
                pdf=ubicacion+"d.pdf";
                break;

        }
        pdfView.fromAsset(pdf).load();
    }
}
