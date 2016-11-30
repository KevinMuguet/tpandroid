package com.example.mutangana.coach.controleur;

import com.example.mutangana.coach.modele.Profil;

/**
 * Created by Mutangana on 16/11/2016.
 */

public final class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private Controle() {
        super() ;
    }
    public static final Controle getInstance(){
        if(Controle.instance==null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     *
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme, 0 pour femme
     */
    public void creerProfil(Integer poids, Integer taille,Integer age, Integer sexe){
        this.profil = new Profil(poids,taille,age,sexe);
    }

    /**
     *
     * @return l'img qui est dans la classe profil
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     *
     * @return retourne le message
     */
    public String  getMessage(){
        return profil.getMessage();
    }
}

