package com.example.mutangana.coach.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mutangana.coach.outils.MesOutils;
import com.example.mutangana.coach.outils.MySQLiteOpenHelper;

import java.util.Date;

/**
 * Created by Mutangana on 30/11/2016.
 */

public class AccesLocal {

    private String nomBase = "bdCoach.sqlite";
    private int versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;
    private String req;



    public AccesLocal(Context context) {

        accesBD = new MySQLiteOpenHelper(context, nomBase, versionBase);
    }

    /**
     * @param profil ajout dans profil
     */
    public void ajoutProfil(Profil profil) {

        bd = accesBD.getWritableDatabase();
        req = "insert into profil values (\"" + MesOutils.convertDateToString(profil.getDateMesure()) + "\"," + profil.getPoids() + "," + profil.getTaille() + "," + profil.getAge() + "," + profil.getSexe() + ")";
        bd.execSQL(req);

    }

    /**
     * recupère le dernier profil
     *
     * @return
     */
    public Profil recupDernier() {
         Profil profil = null;
        bd = accesBD.getReadableDatabase();
        String req2 = "select * from profil order by dateMesure DESC";

        Cursor cursor = bd.rawQuery(req2, null);
        // se positionne sur la première ligne
        Log.d("test","******************"+"avant if");
        if (cursor.moveToFirst()) {
            Date dateMesure =  MesOutils.convertStringToDate(cursor.getString(0));
            Log.d("dateapreslaconvertion","*****************************"+dateMesure);
            int poids = cursor.getInt(1);
            int taille = cursor.getInt(2);
            int age = cursor.getInt(3);
            int sexe = cursor.getInt(4);
            profil= new Profil(poids,taille,age,sexe, dateMesure);
        }
        cursor.close();
        return profil;


    }
}


