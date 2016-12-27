package com.example.mutangana.coach.controleur;

import android.content.Context;
import android.util.Log;

import com.example.mutangana.coach.modele.AccesDistant;
import com.example.mutangana.coach.modele.AccesLocal;
import com.example.mutangana.coach.modele.Profil;
import com.example.mutangana.coach.outils.Serializer;

import org.json.JSONArray;

import java.util.Date;

/**
 * Created by Mutangana on 16/11/2016.
 */

public final class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
   // private static AccesLocal accesLocal;
    private static AccesDistant accesDistant;

    private Controle() {
        super();
    }

    public static final Controle getInstance(Context context) {
        Log.d("test","******************"+"avant if controle");
        if (Controle.instance == null) {
            Controle.instance = new Controle();
            //accesLocal = new AccesLocal(context);
            accesDistant = new AccesDistant() ;
           // profil=accesLocal.recupDernier();
            accesDistant.envoi("dernier", new JSONArray());
            //recupSerialize(context);
            Log.d("test","******************"+"apres if controle");

        }
        return Controle.instance;
    }

    /**
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe   1 pour homme, 0 pour femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context context) {
        this.profil = new Profil(poids, taille, age, sexe, new Date());
        //Serializer.serialize(nomFic, profil, context);
        //accesLocal.ajoutProfil(profil);//ajoute le nouveau profil dans la base locale
        accesDistant.envoi("enreg", profil.convertToJSONArray());
    }

    /**
     * @return l'img qui est dans la classe profil
     */
    public float getImg() {
        return profil.getImg();
    }

    /**
     * @return retourne le message
     */
    public String getMessage() {
        return profil.getMessage();
    }

    private static void  recupSerialize(Context context){
        profil =(Profil)Serializer.deSerialize(nomFic,context);
    }
    public Integer getTaille(){

        if(profil==null){
            return null;
        }
        else{
            return profil.getTaille();
        }
    }
    public Integer getPoids(){

        if(profil==null){
            return null;
        }
        else{
            return profil.getPoids();
        }
    }
    public Integer getAge(){

        if(profil==null){
            return null;
        }
        else{
            return profil.getAge();
        }
    }
    public Integer getSexe(){

        if(profil==null){
            return null;
        }
        else{
            return profil.getSexe();
        }
    }

}

