package com.jose.sisrob.Base_De_Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jose on 22/09/17.
 */

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
       // super(context, name, factory, version);
        super(context, context.getExternalFilesDir(null).getAbsolutePath() + "/" + name , null, version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Consultas.CREAR_TABLA_MOTOR_DEUTZ);
        sqLiteDatabase.execSQL(Consultas.CREAR_TABLA_MOTOR_CAT);
        sqLiteDatabase.execSQL(Consultas.CREAR_TABLA_MOTOR_PERKINS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS motor_deutz");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS motor_perkins");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS motor_cat");
        onCreate(sqLiteDatabase);
    }
}
