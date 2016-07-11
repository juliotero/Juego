package com.example.juli.hangman;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myTextView=(Button)findViewById(R.id.button);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/GoodDog.otf");
        myTextView.setTypeface(typeFace);
    }

    public void empezarJuegoUnJugador(View v){

        Intent nueva = new Intent(this, GameActivity.class);
        startActivity(nueva);
    }




}
