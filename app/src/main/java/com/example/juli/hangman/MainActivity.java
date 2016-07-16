package com.example.juli.hangman;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myTextView=(Button)findViewById(R.id.button);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/GoodDog.otf");
        myTextView.setTypeface(typeFace);
        TextView tituloinicio = (TextView) findViewById(R.id.tituloinicio);
        tituloinicio.setTypeface(typeFace);
    }

    public void empezarJuegoUnJugador(View v){

        Intent nueva = new Intent(this, GameActivity.class);
        startActivity(nueva);
    }

    public void salirDelJuego(View v){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.finishAffinity();
        }

        System.exit(0);
    }




}
