package com.jose.sisrob;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jose.sisrob.Base_De_Datos.Conexion;
import com.jose.sisrob.Fragmentos.Bombas_Hidraulicas;
import com.jose.sisrob.Fragmentos.Codigo_De_Fallas;
import com.jose.sisrob.Fragmentos.Dimenciones_De_Mangueras;
import com.jose.sisrob.Fragmentos.PlanosElectricos;
import com.jose.sisrob.Fragmentos.Preciones_De_Trabajo;
import com.jose.sisrob.Fragmentos.Ubicacion_de_Sensores;
import com.jose.sisrob.Fragmentos.pin;

public class Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {


           try {
               Conexion conexion = new Conexion(getApplicationContext(),"db_motores",null,1);
               conexion.getWritableDatabase();
               Toast.makeText(this, "base de datos creada", Toast.LENGTH_SHORT).show();
           }catch (Exception e){
               Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
           }


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;
        Boolean FragmentoSeleccionado=false;

        int id = item.getItemId();

        /// Electrico
        if (id == R.id.nav_codigodefallas) {
           fragment = new Codigo_De_Fallas();
            FragmentoSeleccionado = true;
        }else if (id== R.id.nav_posiblesfallas){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("SISROB ESTA TRABAJANDO PARA SU COMODIDAD  DE USTED\"\n" +
                    "\"ACTIVO EN L SIGUIENTE VERSION");
            dlgAlert.setTitle(getString(R.string.app_name));
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }else if (id == R.id.nav_pin){
            fragment = new pin();
            FragmentoSeleccionado = true;
        }else if (id == R.id.nav_planoselectricos){
            fragment = new PlanosElectricos();
            FragmentoSeleccionado = true;
        }else if (id == R.id.nav_ubicaciondesensores){
            fragment = new Ubicacion_de_Sensores();
            FragmentoSeleccionado = true;
        }


        // Hidraulico
        else if (id== R.id.nav_bombashidraulicas){
            fragment = new Bombas_Hidraulicas();
            FragmentoSeleccionado=true;
        }else if (id==R.id.nav_dimencionesdemangueras){
            fragment = new Dimenciones_De_Mangueras();
            FragmentoSeleccionado=true;
        }else if (id==R.id.nav_presionesdetrabajo){
            fragment = new Preciones_De_Trabajo();
            FragmentoSeleccionado=true;
        }
        if (FragmentoSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
