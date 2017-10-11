package com.jose.sisrob.Activitys.Electrico.Codigo_De_Fallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jose.sisrob.Base_De_Datos.Conexion;
import com.jose.sisrob.R;

public class Resultados extends AppCompatActivity {


    TextView [] texto = new TextView[5];
    TextView [] titulo= new TextView[5];
    Integer id;
    String accionrecibida, datorecibido;
    Conexion con;
    SQLiteDatabase db;
    String [] parametro;
    String [] campos;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadoscodigodefallas);

        texto [0] = (TextView)findViewById(R.id.texto1);
        texto [1] = (TextView)findViewById(R.id.texto2);
        texto [2] = (TextView)findViewById(R.id.texto3);
        texto [3] = (TextView)findViewById(R.id.texto4);
        texto [4] = (TextView)findViewById(R.id.texto5);

        titulo [0] = (TextView)findViewById(R.id.txttitulo1);
        titulo [1] = (TextView)findViewById(R.id.txttitulo2);
        titulo [2] = (TextView)findViewById(R.id.txttitulo3);
        titulo [3] = (TextView)findViewById(R.id.txttitulo4);
        titulo [4] = (TextView)findViewById(R.id.txttitulo5);

        Bundle parametros = this.getIntent().getExtras();

        id = parametros.getInt("id",0);
        accionrecibida = parametros.getString("accionrecibida");
        datorecibido = parametros.getString("falla");


       Toast.makeText(this, datorecibido, Toast.LENGTH_SHORT).show();

         con = new Conexion(getApplicationContext(),"bd_motores",null,1);
         db  = con.getWritableDatabase();

        switch (accionrecibida){
            case "1":

                parametro = new String[]{datorecibido};
                campos = new String[]{"DESCRIPCIONDELAAVERIA","CONDICIONDEAVERIA","CONSECUENCIASPARAELEQUIPO","POSIBLESFALLAS"};

                 cursor=db.query("motor_deutz",campos,"NRODEFALLA=?",parametro,null,null,null);
                 cursor.moveToFirst();

                texto[0].setText(cursor.getString(0));
                texto[1].setText(cursor.getString(1));
                texto[2].setText(cursor.getString(2));
                texto[3].setText(cursor.getString(3));
                texto[4].setVisibility(View.GONE);


                titulo[0].setText("DESCRIPCIÓN DE AVERIA");
                titulo[1].setText("CONDICIÓN DE AVERIA");
                titulo[2].setText("CONCECUENCIAS PARA EL EQUIPO");
                titulo[3].setText("POSIBLES FALLAS");
                titulo[4].setVisibility(View.GONE);

                break;
            case "2":

                Toast.makeText(this, datorecibido, Toast.LENGTH_SHORT).show();
                //select ,,,, from motor_perkins where id='1';

                parametro = new String[]{datorecibido};
                campos = new String[]{"DESCRIPCIONDELAAVERIA","CONDICIONDEAVERIA","RESPUESTADELEQUIPO","CONDICIONPREQUIPO","POSIBLEFALLAYSOLUCION"};

                cursor=db.query("motor_perkins",campos,"CodigoCDL=?",parametro,null,null,null);
                cursor.moveToFirst();

                texto[0].setText(cursor.getString(0));
                texto[1].setText(cursor.getString(1));
                texto[2].setText(cursor.getString(2));
                texto[3].setText(cursor.getString(3));
                texto[4].setText(cursor.getString(4));



                titulo[0].setText("DESCRIPCIÓN DE AVERIA");
                titulo[1].setText("CONDICIÓN DE AVERIA");
                titulo[2].setText("RESPUESTA DE EQUIPO");
                titulo[3].setText("CONCECUENCIAS PARA EL EQUIPO");
                titulo[4].setText("POSIBLES FALLAS Y SOLUCIÓN");


                break;

        }


    }
}
