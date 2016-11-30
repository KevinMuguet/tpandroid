package com.example.mutangana.coach.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mutangana.coach.outils.MySQLiteOpenHelper;

/**
 * Created by Mutangana on 30/11/2016.
 */

public class AccesLocal {

    private String nomBase = "bdCoach.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;
    private String req;
    private Profil profil = null;

    public AccesLocal(Context context) {

        accesBD = new MySQLiteOpenHelper(context, nomBase, versionBase);
    }

    /**
     *
     * @param profil
     * ajout dans profil
     */
    public void ajoutProfil(Profil profil) {

        bd = accesBD.getWritableDatabase();
        req = "INSERT INTO PROFIL VALUES (\"" + profil.getDateMesure() + "\"," + profil.getPoids() + "," + profil.getTaille() + "," + profil.getAge() + "," + profil.getSexe() + ")";
        bd.execSQL(req);
    }

    /**
     * recupère le dernier profil
     * @return
     */
    public Profil recupDernier() {

        bd = accesBD.getReadableDatabase();
        req = "SELECT* FROM PROFIL ORDER BY dateMesure desc";
        Cursor cursor=bd.rawQuery(req,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst()){

            cursor.getInt(profil.getSexe());
            cursor.getInt(profil.getAge());
            cursor.getInt(profil.getPoids());
            cursor.getInt(profil.getTaille());
            cursor.getInt((profil)(date)(dateme))
        }


    }
}


