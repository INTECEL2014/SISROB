package com.jose.sisrob.Base_De_Datos;

/**
 * Created by jose on 22/09/17.
 */

public class Consultas {

    public static final String CREAR_TABLA_MOTOR_DEUTZ="CREATE TABLE `motor_deutz` (\n" +
            "\t`id`\tTEXT,\n" +
            "\t`DESTELLO`\tTEXT,\n" +
            "\t`NRODEFALLA`\tTEXT,\n" +
            "\t`DESCRIPCIONDELAAVERIA`\tTEXT,\n" +
            "\t`CONDICIONDEAVERIA`\tTEXT,\n" +
            "\t`CONSECUENCIASPARAELEQUIPO`\tTEXT,\n" +
            "\t`POSIBLESFALLAS`\tTEXT,\n" +
            "\t`SPN`\tTEXT\n" +
            ");";
    public static final String CREAR_TABLA_MOTOR_PERKINS="CREATE TABLE \"motor_perkins\" (\n" +
            "\t`ID`\tTEXT,\n" +
            "\t`MOTOR`\tTEXT,\n" +
            "\t`CodigoCDL`\tTEXT,\n" +
            "\t`DESCRIPCIONDELAAVERIA`\tTEXT,\n" +
            "\t`CONDICIONDEAVERIA`\tTEXT,\n" +
            "\t`RESPUESTADELEQUIPO`\tTEXT,\n" +
            "\t`CONDICIONPREQUIPO`\tTEXT,\n" +
            "\t`POSIBLEFALLAYSOLUCION`\tTEXT,\n" +
            "\t`CodigoJ1939dedispositivodeterceros`\tTEXT,\n" +
            "\t`Codigodedestello`\tTEXT\n" +
            ")";

    public static final String CREAR_TABLA_MOTOR_CAT="CREATE TABLE \"motor_cat\" (\n" +
            "\t`ID`\tTEXT,\n" +
            "\t`NRODEFMI`\tTEXT,\n" +
            "\t`DESCRIPCION`\tTEXT,\n" +
            "\t`CIDDescripcion`\tTEXT,\n" +
            "\t`MID`\tTEXT,\n" +
            "\t`NRODEFALLADESCRIPCION`\tTEXT\n" +
            ")";

    public static final String SELECCCIONAR_NUMERO_DE_FALLAS_MOTOR_DEUTZ = "select NRODEFALLA from motor_deutz where  DESTELLO=";
    public static final String SELECCCIONAR_NUMERO_DE_FALLAS_PERKINS = "select CodigoCDL from motor_perkins where Codigodedestello=";
    public static final String MOSTRAR_CID_MOTOR_CAT="select dato from motor_id_cid";



}
