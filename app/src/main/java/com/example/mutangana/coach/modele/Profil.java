package com.example.mutangana.coach.modele;

import com.example.mutangana.coach.outils.Serializer;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mutangana on 15/11/2016.
 */

public class Profil implements Serializable {
    private static final Integer minFemme = 15; // maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer minHomme = 10; // maigre si en dessous
    private static final Integer maxHomme = 25; // gros si au dessus
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;
    private Date dateMesure;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe, Date dateMesure ) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.dateMesure= dateMesure;
        calculIMG();
        resultIMG();


    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    private void calculIMG(){

        float tailleFloat =(float)(taille)/100;// on convertit en float pour pouvoir passer de cm en m
        float img1 = (float)((1.2*poids/(tailleFloat*tailleFloat))+(0.23*age)-(10.83*sexe)-5.4);
        img=(float)img1;
    }
    private void resultIMG(){
        if(sexe==0 ) {

            if (img < minFemme) {
                message = "trop faible";
            }

            if (img >= maxFemme) {
                message = "trop élevé";
            }

            if (img > minFemme && img < maxFemme) {
                message = "normale";
            }
        }
        else {

            if (img < minHomme) {
                message = "trop faible";
            }

            if (img >= minHomme) {
                message = "trop élevé";
            }

            if (img > minHomme && img < maxHomme) {
                message = "normale";
            }
        }
    }

    public Date getDateMesure() {
        return dateMesure;
    }
    public JSONArray convertToJSONArray(){
        List tableau = new ArrayList();
        tableau.add(dateMesure);
        tableau.add(poids);
        tableau.add(taille);
        tableau.add(age);
        tableau.add(sexe);

        JSONArray res = new JSONArray(tableau);
        return res;

    }
}
