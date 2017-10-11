package com.jose.sisrob.Activitys.Bombas_HIdraulicas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.R;

public class Resultados_Bombas_Hidraulicas extends AppCompatActivity {
    String pdf = "";
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados__bombas__hidraulicas);

        pdfView = (PDFView)findViewById(R.id.pdfbombashidraulicas);

        Bundle bundle = getIntent().getExtras();
        String ubicacion = bundle.getString("ubicacion").trim();
        Toast.makeText(this, ubicacion, Toast.LENGTH_SHORT).show();



        switch (ubicacion){
            case "ALPHA 20":
                pdf=ubicacion+"h.pdf";
                break;
             case "TORNADO":
                 pdf=ubicacion+"h.pdf";
                break;
             case "TORNADO S2":
                 pdf=ubicacion+"h.pdf";
                break;
             case "COGUARO 4":
                 pdf=ubicacion+"h.pdf";
                break;
             case "MIXKRET 4":
                 pdf=ubicacion+"h.pdf";
                break;

        }
        pdfView.fromAsset(pdf).load();
    }
}
