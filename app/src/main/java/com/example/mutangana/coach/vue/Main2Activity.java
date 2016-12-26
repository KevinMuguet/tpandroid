package com.example.mutangana.coach.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.mutangana.coach.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        creerMenu();
    }
    public void creerMenu(){
        ecouteMenu(ImageButton(findViewById.uneimage), MainActivity.class);
        ecouteMenu(ImageButton(findViewById.uneimage), MainActivity.class);
    }

    private void ecouteMenu(ImageButton uneimage,final Class classe) {

        uneimage.setOnClickListener(Intent objet = new Intent);
    }

}
