package com.example.juli.hangman;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PantallaJuego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        //asignar font a lblElegirLetra
        TextView lblElegirLetra=(TextView)findViewById(R.id.lblElegirLetra);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/GoodDog.otf");
        lblElegirLetra.setTypeface(typeFace);

        //asignar font a lblFallidas
        TextView lblFallidas=(TextView)findViewById(R.id.lblFallidas);
        lblFallidas.setTypeface(typeFace);

        //Asignar font a boton
        Button btnOk=(Button)findViewById(R.id.boton_ok);
        btnOk.setTypeface(typeFace);
    }
}
