package com.example.juli.hangman;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameActivity extends AppCompatActivity {

    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        nombre   = (EditText)findViewById(R.id.nombre);
        Button myTextView=(Button)findViewById(R.id.botonJugar);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Zachary.ttf");
        myTextView.setTypeface(typeFace);
    }

    public void empezarJuego(View v){

        Intent nueva = new Intent(this, PantallaJuego.class);
        nueva.putExtra("NOMBRE", nombre.getText());
        startActivity(nueva);
    }
}
