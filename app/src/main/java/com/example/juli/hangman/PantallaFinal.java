package com.example.juli.hangman;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaFinal extends AppCompatActivity {

    private int puntaje;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);
        Intent intent = getIntent();
        puntaje = intent.getIntExtra("PUNTAJE",0);
        nombre = intent.getStringExtra("NOMBRE");
        TextView txtPuntaje = (TextView) findViewById(R.id.txtPuntaje);
        txtPuntaje.setText(txtPuntaje.getText() + " " + puntaje);
        TextView titulofinal = (TextView) findViewById(R.id.titulofinal);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/GoodDog.otf");
        titulofinal.setTypeface(typeFace);
        Button btnTerminar = (Button) findViewById(R.id.btnTerminar);
        btnTerminar.setTypeface(typeFace);
        Button btnSeguirJugando = (Button) findViewById(R.id.btnSeguirJugando);
        btnSeguirJugando.setTypeface(typeFace);
    }

    public void volverAJugar(View v){

        Intent nueva = new Intent(this, PantallaJuego.class);
        nueva.putExtra("NOMBRE", nombre);
        nueva.putExtra("PUNTAJE", puntaje);
        startActivity(nueva);
        this.finish();
    }

    public void terminarJuego(View v){

        this.finish();
    }
}
