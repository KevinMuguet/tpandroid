package com.example.mutangana.coach.modele;

import android.util.Log;

import com.example.mutangana.coach.outils.AccesHTTP;
import com.example.mutangana.coach.outils.AsyncResponse;

import org.json.JSONArray;

/**
 * Created by Mutangana on 07/12/2016.
 */

public class AccesDistant implements AsyncResponse {
    public final String SERVERADDR = "http://192.168.1.24/coach/serveurcoach.php";

    /**
     * constructeur
     */
    public AccesDistant() {
        super();
    }

    /**
     * gere le retour asynchrone du serveur
     *
     * @param output
     */
    @Override
    public void processFinish(String output) {
        Log.d("serveur", "************" + output);
        String[] message = output.split("%");
        if (message.length > 1) {
            if (message[0].equals("enreg")) {
                Log.d("serveur", "************" + message[0]);
            }
            if (message[0].equals("dernier")) {
                Log.d("serveur", "************" + message[0]);
            }
            if (message[0].equals("Erreur !")) {
                Log.d("serveur", "************" + message[0]);
            }
        }

    }

    public void envoi(String operation, JSONArray lesDonneesJSON) {

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);





    }

    ;
}