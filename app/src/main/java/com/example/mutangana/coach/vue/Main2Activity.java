package com.example.mutangana.coach.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mutangana.coach.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        creerMenu();
    }
    public void creerMenu() {
    //    ecouteMenu((ImageButton)findViewById(R.id.normal),MainActivity.class); // la page de l'interface de calcul
       // ecouteMenu((ImageButton)findViewById(R.id.historique),HistoActivity.class); //  la page historique
    }

    public void ecouteMenu (ImageButton uneImage, final Class classe) {

        (uneImage).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent unIntent = new Intent(Main2Activity.this,classe); // Permet de relier les activity
                startActivity(unIntent);


            }
        });
    }
}
