package com.example.mutangana.coach.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mutangana on 06/12/2016.
 */

public abstract class MesOutils {

    /**
     *  le formatage de la date
     * @param
     * @return
     */
    public static Date convertStringToDate(String unedate) {


        String expectedPattern ="dd/MM/yy HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
        try {

            Date date = formatter.parse(unedate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }
    public static String convertDateToString(Date uneDate){
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        return date.format(uneDate);
    }
}
