package com.example.mutangana.coach.modele;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Mutangana on 15/11/2016.
 */
public class ProfilTest {

    // création d'un profil : femme de 67kg, 1m65, 35 ans
    private Profil profil = new Profil(67, 165, 35, 0,new Date());
    // résultat de l'img correspondant
    private float img = (float)32.2;
    // message correspondant
    private String message = "trop élevé" ;
    @Test
    public void getImg() throws Exception {
        assertEquals(img, profil.getImg(), (float)0.1);
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message, profil.getMessage());
    }

}
