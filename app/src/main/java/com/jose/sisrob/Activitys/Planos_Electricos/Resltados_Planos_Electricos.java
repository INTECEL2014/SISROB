package com.jose.sisrob.Activitys.Planos_Electricos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.jose.sisrob.R;

public class Resltados_Planos_Electricos extends AppCompatActivity {

    PDFView pdfView;
    String pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resltados__planos__electricos);
        Bundle bundle = getIntent().getExtras();
        String plano = bundle.getString("plano");
        pdfView = (PDFView)findViewById(R.id.pdf_planos_electricos);
        Toast.makeText(this, plano, Toast.LENGTH_SHORT).show();

        pdf = plano+".pdf".toString().trim();

/*
        switch (plano){
            case "":
                ";
                break;
            case  "":
                break;
            case "ALPHA 30":
                break;
            case "":
                break;
            case "":
                break;
            case "":
                break;
            case "":
                break;
            case "":
                break;
            case "":
                break;
            case "":
                break;


        }
*/
        pdfView.fromAsset(pdf).load();
    }
}
