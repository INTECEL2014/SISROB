package com.jose.sisrob.Activitys.Electrico.Codigo_De_Fallas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jose.sisrob.Base_De_Datos.Conexion;
import com.jose.sisrob.Base_De_Datos.Consultas;
import com.jose.sisrob.R;

import java.util.ArrayList;

public class Consulta extends AppCompatActivity {

    String accionrecibida1;
    Conexion con;
    SQLiteDatabase db;
    ArrayAdapter adaptador;
    String consulta,datorecibido;
    Cursor registros;
    Bundle parametros;
    ListView listaa;
    String falla;
    TextView [] informacion ,titulos;
    String []parametro,campos ;
    Cursor cursor;
    ArrayList<String> listas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);



        con = new Conexion(getApplicationContext(), "bd_motores", null, 1);
        db = con.getWritableDatabase();

        LinearLayout [] contenedor = new LinearLayout[11];


        parametros = this.getIntent().getExtras();
        datorecibido = parametros.getString("dato");
        final Integer accionrecibida = parametros.getInt("accion",0);


        contenedor[0] = (LinearLayout)findViewById(R.id.accion1);
        contenedor[1] = (LinearLayout)findViewById(R.id.accion2);
        contenedor[2] = (LinearLayout)findViewById(R.id.accion3);
        contenedor[3] = (LinearLayout)findViewById(R.id.accion4);
        contenedor[4] = (LinearLayout)findViewById(R.id.accion5);
        contenedor[5] = (LinearLayout)findViewById(R.id.accion6);
        contenedor[6] = (LinearLayout)findViewById(R.id.accion7);
        contenedor[7] = (LinearLayout)findViewById(R.id.accion8);
        contenedor[8] = (LinearLayout)findViewById(R.id.accion9);
        contenedor[9] = (LinearLayout)findViewById(R.id.accion10);
        contenedor[10] = (LinearLayout)findViewById(R.id.accion11);


        switch (accionrecibida) {
            case 1:
                try {
                    contenedor[0].setVisibility(View.VISIBLE);

                    listaa = (ListView) findViewById(R.id.listaaccion1);

                    ArrayList<String> listas = new ArrayList<>();

                    consulta = Consultas.SELECCCIONAR_NUMERO_DE_FALLAS_MOTOR_DEUTZ + "'" + datorecibido.toString() + "';";
                    registros = db.rawQuery(consulta, null);

                    if (registros.moveToFirst()) {
                        do {
                            listas.add(registros.getString(0));
                        } while (registros.moveToNext());
                    }


                    adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listas);

                    listaa.setAdapter(adaptador);
                    db.close();
                    int tamanodeadaptador = listaa.getCount();

                    if (tamanodeadaptador==0){
                        Toast.makeText(this, "dato inexistente favor de verificar", Toast.LENGTH_SHORT).show();
                        this.finish();
                    }
                    listaa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                            falla = listaa.getItemAtPosition(position).toString().trim();


                            Intent intent = new Intent(getApplicationContext(), Resultados.class);
                            intent.putExtra("accionrecibida", "1");
                            intent.putExtra("falla", falla);
                            startActivity(intent);

                        }
                    });
                }catch (Exception e){
                    Toast.makeText(this, "dato inexistente favor de verificar", Toast.LENGTH_SHORT).show();
                }

                break;
            case 2:
                contenedor[1].setVisibility(View.VISIBLE);

                try {

                    informacion = new TextView[4];

                    informacion[0] = (TextView) findViewById(R.id.txtinfo1);
                    informacion[1] = (TextView) findViewById(R.id.txtinfo2);
                    informacion[2] = (TextView) findViewById(R.id.txtinfo3);
                    informacion[3] = (TextView) findViewById(R.id.txtinfo4);

                    //select DESCRIPCIONDELAAVERIA,CONDICIONDEAVERIA,CONSECUENCIASPARAELEQUIPO,POSIBLESFALLAS FROM motor_deutz  WHERE  nrodefalla = 'P011';

                    parametro = new String[]{datorecibido};
                    campos = new String[]{"DESCRIPCIONDELAAVERIA", "CONDICIONDEAVERIA", "CONSECUENCIASPARAELEQUIPO", "POSIBLESFALLAS"};


                    cursor = db.query("motor_deutz", campos, "nrodefalla=?", parametro, null, null, null);
                    cursor.moveToFirst();

                    informacion[0].setText(cursor.getString(0));
                    informacion[1].setText(cursor.getString(1));
                    informacion[2].setText(cursor.getString(2));
                    informacion[3].setText(cursor.getString(3));
                } catch (Exception e) {
/*

                 */
                    Toast.makeText(this, "No existe este dato en la base de datos intentelo de nuevo", Toast.LENGTH_SHORT).show();
                    this.finish();
                }

                break;
            case 3:
                contenedor[2].setVisibility(View.VISIBLE);

                break;
            case 4:
                contenedor[3].setVisibility(View.VISIBLE);
                break;
            case 5:
                contenedor[4].setVisibility(View.VISIBLE);

                listaa = (ListView) findViewById(R.id.listaaccion5);


                listas = new ArrayList<>();
                consulta = Consultas.SELECCCIONAR_NUMERO_DE_FALLAS_PERKINS + "'" + datorecibido.toString() + "';";
                registros = db.rawQuery(consulta, null);

                if (registros.moveToFirst()) {
                    do {
                        listas.add(registros.getString(0));
                    } while (registros.moveToNext());
                }


                adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listas);

                listaa.setAdapter(adaptador);
                db.close();
                int tamanodeadaptador = listaa.getCount();
                if (tamanodeadaptador==0){
                    Toast.makeText(this, "dato inexistente favor de verificar", Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                listaa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        falla = listaa.getItemAtPosition(position).toString().trim();
                        Intent intent = new Intent(getApplicationContext(), Resultados.class);
                        intent.putExtra("accionrecibida", "2");
                        intent.putExtra("falla", falla);
                        startActivity(intent);

                    }
                });
                break;
            case 6:
                contenedor[5].setVisibility(View.VISIBLE);

                try {
                    Toast.makeText(this, datorecibido, Toast.LENGTH_SHORT).show();
                    informacion = new TextView[5];
                    informacion[0] = (TextView) findViewById(R.id.informacion1accion6);
                    informacion[1] = (TextView) findViewById(R.id.informacion2accion6);
                    informacion[2] = (TextView) findViewById(R.id.informacion3accion6);
                    informacion[3] = (TextView) findViewById(R.id.informacion4accion6);
                    informacion[4] = (TextView) findViewById(R.id.informacion5accion6);

                    titulos = new TextView[5];
                    titulos[0] = (TextView)findViewById(R.id.titulo1accion6);
                    titulos[1] = (TextView)findViewById(R.id.titulo2accion6);
                    titulos[2] = (TextView)findViewById(R.id.titulo3accion6);
                    titulos[3] = (TextView)findViewById(R.id.titulo4accion6);
                    titulos[4] = (TextView)findViewById(R.id.titulo5accion6);

                    titulos[0].setText("DESCRIPCIÓN DE AVERIA");
                    titulos[1].setText("CONDICIÓN DE AVERIA");
                    titulos[2].setText("RESPUESTA DE EQUIPO");
                    titulos[3].setText("CONCECUENCIAS PARA EL EQUIPO");
                    titulos[4].setText("POSIBLES FALLAS Y SOLUCIÓN");

                    parametro = new String[]{datorecibido};
                    campos = new String[]{"DESCRIPCIONDELAAVERIA","CONDICIONDEAVERIA","RESPUESTADELEQUIPO","CONDICIONPREQUIPO","POSIBLEFALLAYSOLUCION"};


                    cursor=db.query("motor_perkins",campos,"CodigoCDL=?",parametro,null,null,null);
                    cursor.moveToFirst();

                informacion[0].setText(cursor.getString(0));
                informacion[1].setText(cursor.getString(1));
                informacion[2].setText(cursor.getString(2));
                informacion[3].setText(cursor.getString(3));
                informacion[4].setText(cursor.getString(4));

                }catch (Exception e){
                    Toast.makeText(this, "No existe este dato en la base de datos intentelo de nuevo", Toast.LENGTH_SHORT).show();
                    this.finish();
                }



                break;
            case 7:
                try {
                    Toast.makeText(this, datorecibido, Toast.LENGTH_SHORT).show();
                    informacion = new TextView[5];
                    informacion[0] = (TextView) findViewById(R.id.texto1accion7);
                    informacion[1] = (TextView) findViewById(R.id.texto2accion7);
                    informacion[2] = (TextView) findViewById(R.id.texto3accion7);
                    informacion[3] = (TextView) findViewById(R.id.texto4accion7);
                    informacion[4] = (TextView) findViewById(R.id.texto5accion7);

                    titulos = new TextView[5];
                    titulos[0] = (TextView)findViewById(R.id.txttitulo1accion7);
                    titulos[1] = (TextView)findViewById(R.id.txttitulo2accion7);
                    titulos[2] = (TextView)findViewById(R.id.txttitulo3accion7);
                    titulos[3] = (TextView)findViewById(R.id.txttitulo4accion7);
                    titulos[4] = (TextView)findViewById(R.id.txttitulo5accion7);

                    titulos[0].setText("DESCRIPCIÓN DE AVERIA");
                    titulos[1].setText("CONDICIÓN DE AVERIA");
                    titulos[2].setText("RESPUESTA DE EQUIPO");
                    titulos[3].setText("CONCECUENCIAS PARA EL EQUIPO");
                    titulos[4].setText("POSIBLES FALLAS Y SOLUCIÓN");

                    parametro = new String[]{datorecibido};
                    campos = new String[]{"DESCRIPCIONDELAAVERIA","CONDICIONDEAVERIA","RESPUESTADELEQUIPO","CONDICIONPREQUIPO","POSIBLEFALLAYSOLUCION"};


                    cursor=db.query("motor_perkins",campos,"CodigoJ1939dedispositivodeterceros=?",parametro,null,null,null);
                    cursor.moveToFirst();

                    informacion[0].setText(cursor.getString(0));
                    informacion[1].setText(cursor.getString(1));
                    informacion[2].setText(cursor.getString(2));
                    informacion[3].setText(cursor.getString(3));
                    informacion[4].setText(cursor.getString(4));

                }catch (Exception e){
                    Toast.makeText(this, "No existe este dato en la base de datos intentelo de nuevo", Toast.LENGTH_SHORT).show();
                    this.finish();
                }



                contenedor[6].setVisibility(View.VISIBLE);
                break;
            case 8:
                contenedor[7].setVisibility(View.VISIBLE);
                break;
            case 9:
                try {
                    Toast.makeText(this, datorecibido, Toast.LENGTH_SHORT).show();
                    informacion = new TextView[1];
                    informacion[0] = (TextView) findViewById(R.id.textoaccion9);


                    titulos = new TextView[1];
                    titulos[0] = (TextView)findViewById(R.id.tituloaccion9);


                    titulos[0].setText("DESCRIPCIÓN DE FALLA");


                    // select descripcion from motor_cat where nrodefalla = '1'
                    parametro = new String[]{datorecibido};
                    campos = new String[]{"descripcion"};


                    cursor=db.query("motor_cat",campos,"nrodefalla=?",parametro,null,null,null);
                    cursor.moveToFirst();

                    informacion[0].setText(cursor.getString(0));



                }catch (Exception e){
                    Toast.makeText(this, "No existe este dato en la base de datos intentelo de nuevo", Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                contenedor[8].setVisibility(View.VISIBLE);

                break;
            case 10:
                contenedor[9].setVisibility(View.VISIBLE);
                informacion = new TextView[16];
                informacion [0] =(TextView)findViewById(R.id.informacion1accion10);
                informacion [1] =(TextView)findViewById(R.id.informacion2accion10);
                informacion [2] =(TextView)findViewById(R.id.informacion3accion10);
                informacion [3] =(TextView)findViewById(R.id.informacion4accion10);
                informacion [4] =(TextView)findViewById(R.id.informacion5accion10);
                informacion [5] =(TextView)findViewById(R.id.informacion6accion10);
                informacion [6] =(TextView)findViewById(R.id.informacion7accion10);
                informacion [7] =(TextView)findViewById(R.id.informacion8accion10);
                informacion [8] =(TextView)findViewById(R.id.informacion9accion10);
                informacion [9] =(TextView)findViewById(R.id.informacion10accion10);
                informacion [10] =(TextView)findViewById(R.id.informacion11accion10);
                informacion [11] =(TextView)findViewById(R.id.informacion12accion10);
                informacion [12] =(TextView)findViewById(R.id.informacion13accion10);
                informacion [13] =(TextView)findViewById(R.id.informacion14accion10);
                informacion [14] =(TextView)findViewById(R.id.informacion15accion10);
                informacion [15] =(TextView)findViewById(R.id.informacion16accion10);

                String texto[] = new String[16];
                texto[0] =" \" datos válidos pero sobre gama operacional normal \". Si una entrada todavía está funcionando en la gama válida pero la entrada está enviando una señal que esté sobre el límite aceptable del parámetro, un código de FMI 00 será generado. En gato los acontecimientos data-link se utilizan normalmente para esta condición.\n";
                texto[1] ="\" datos válidos pero debajo de gama operacional normal \". Una entrada que todavía está funcionando en la gama válida pero está enviando una señal debajo del límite aceptable del parámetro causará el código de FMI 01. En gato los acontecimientos data-link se utilizan normalmente para esta condición.\n";
                texto[2] ="\" datos erráticos, intermitentes, o incorrectos \". Los datos erráticos o intermitentes incluyen todas las medidas que cambien a una tarifa que no se considere posible en la condición del mundo real y se deba causar por la operación incorrecta del aparato de medición o la conexión al módulo. Los datos de la señal de un componente están presentes, por lo menos intermitentemente. La señal es inestable o inválida según lo reconocido por el control que hace diagnósticos. Los datos pueden estar correctos a veces y no en otras veces. FMI 02 también se utiliza para los datos que son inválidos, por ejemplo un estado inválido de un interruptor de la paridad.\n";
                texto[3] =" \" voltaje sobre normal \". FMI 03 ocurre cuando la lectura del voltaje del circuito identificado está sobre la gama válida. FMI 03 se relaciona lo más a menudo posible con un circuito de la señal.\n";
                texto[4] ="\" voltaje debajo del normal \". FMI 04 ocurre cuando la lectura del voltaje del circuito identificado está debajo de la gama válida. FMI 04 se relaciona lo más a menudo posible con un circuito de la señal.\n";
                texto[5] ="\" corriente debajo del normal \". FMI 05 ocurre cuando la corriente a través del circuito identificado está debajo de la gama válida. FMI 05 se relaciona lo más a menudo posible con un circuito del conductor.\n";
                texto[6] ="\" corriente sobre normal \". FMI 06 ocurre cuando la corriente a través del circuito identificado está sobre la gama válida. FMI 06 se relaciona lo más a menudo posible con un circuito del conductor.\n";
                texto[7] ="\" sistema mecánico que no responde correctamente \". FMI 07 ocurre cuando un control electrónico envía un comando eléctrico a un sistema mecánico y el resultado no está dentro de la gama aceptable. Un ejemplo de FMI 07 ocurre cuando la transmisión del ICM (EPTC II) está cambiando de puesto lentamente como resultado de una válvula electromagnética inactiva.\n";
                texto[8] ="\" frecuencia, anchura de pulso, o período anormal \". FMI 08 ocurre cuando una frecuencia de la señal o de la anchura de pulso de la señal no está dentro de la gama se espera que.\n";
                texto[9] =" \" tarifa anormal de la actualización \". FMI 09 pertenece a la comunicación entre los controles electrónicos en la transmisión de datos. FMI 09 ocurre cuando un control electrónico no puede recibir ninguna información de otro control electrónico, cuando el control electrónico espera recibir la información.\n";
                texto[10] =" \" tarifa de cambio anormal \". FMI 10 se relaciona con una señal que cambie demasiado rápido o demasiado lento. El índice de cambio está afuera del límite previsto, pero posible en el mundo real.\n";
                texto[11] ="\" modo de fallo no identificable \". FMI 11 ocurre cuando el control electrónico identifica más de un FMI como siendo responsable de un solo problema, o cuando el modo de fallo no ajusta correctamente en ninguÌ n otro FMI. FMI 12 \" maÌ n dispositivo o componente \". FMI 12 ocurre cuando un dispositivo elegante (tal como un ECU) lo ha determinado ha fallado.\n";
                texto[12] =" \" fuera de la calibración \". FMI 13 ocurre cuando se requiere la calibración. O la calibración nunca se ha realizado o el sistema ha salido de la calibración.\n";
                texto[13] ="\" instrucción especial \". Se utiliza FMI 14 cuando un procedimiento especial o una información más detallada se requiere entenderlo.\n";
                texto[14] ="\" recibió datos de la red en error \". FMI 19 se asocia a los datos de la red se reciben que. El componente que se utiliza para medir la señal del mundo real se ata con alambre directo al módulo que es compra de componentes los datos a la red. El módulo que está recibiendo los datos vía la red está recibiendo la información con un indicador de error, y no los datos reales.\n";



                for (int i =0 ;i<16;i++){
                    informacion[i].setText(Html.fromHtml("<div align=\"justify\">"+texto[i]+"</div>"));
                }
                informacion[15].setText(texto[15] =getString(R.string.nota));

                break;
            case 11:
                contenedor[10].setVisibility(View.VISIBLE);
                listaa = (ListView) findViewById(R.id.listaaccion11);

                ArrayList<String> listas1 = new ArrayList<>();

                consulta = Consultas.MOSTRAR_CID_MOTOR_CAT;
                registros = db.rawQuery(consulta, null);

                if (registros.moveToFirst()) {
                    do {
                        listas1.add(registros.getString(0));
                    } while (registros.moveToNext());
                }


                adaptador = new ArrayAdapter<String>(this, R.layout.lista, listas1);

                listaa.setAdapter(adaptador);
                db.close();
                break;

        }

        //Accion 1 motor deutz -- destello


//// acccion 2 motor deutz -- numero de fallas

    }

}
