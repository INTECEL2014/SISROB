package com.jose.sisrob.Activitys.Preciones_De_Trabajo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.R;

public class Resultado_Preciones_De_Trabajo extends AppCompatActivity {
    String pdf = "";
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado__preciones__de__trabajo);


        pdfView = (PDFView)findViewById(R.id.pdfprecionesdetrabajo);

        Bundle bundle = getIntent().getExtras();
        String ubicacion = bundle.getString("ubicacion").trim();
        Toast.makeText(this, ubicacion, Toast.LENGTH_SHORT).show();

        //   ubicacion="/bombashidraulicas"+ubicacion;

        switch (ubicacion){
            case "ALPHA 20":
                pdf=ubicacion+"p.pdf";
                break;
            case "TORNADO":
                pdf=ubicacion+"p.pdf";
                break;
            case "TORNADO S2":
                pdf=ubicacion+"p.pdf";
                break;
            case "CST 8.20":
                pdf=ubicacion+"p.pdf";
                break;
            case "MIXKRET 4":
                pdf=ubicacion+"p.pdf";
                break;

        }
        pdfView.fromAsset(pdf).load();

    }
}
