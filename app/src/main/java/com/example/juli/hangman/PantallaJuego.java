package com.example.juli.hangman;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PantallaJuego extends AppCompatActivity {

    private int maximoPuntaje;
    private String nombre;
    private int puntaje;
    private String[] palabras = {"google", "letras", "pensar", "minero", "valido", "basico", "celula", "lengua", "hombre", "bovina", "pelota", "calaca", "fritas", "numero", "padres"};
    private String palabraAAdivinar;
    private EditText letra;
    TextView lblFallidas;
    TextView letra1;
    TextView letra2;
    TextView letra3;
    TextView letra4;
    TextView letra5;
    TextView letra6;
    int intentos;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);
        maximoPuntaje=60;
        intentos=0;
        Intent intent = getIntent();
        nombre = intent.getStringExtra("NOMBRE");
        puntaje = 0;
        int indice = new Random().nextInt(15);
        palabraAAdivinar = palabras[indice];

        //obtener elementos de letras
        letra1=(TextView)findViewById(R.id.letra1);
        letra2=(TextView)findViewById(R.id.letra2);
        letra3=(TextView)findViewById(R.id.letra3);
        letra4=(TextView)findViewById(R.id.letra4);
        letra5=(TextView)findViewById(R.id.letra5);
        letra6=(TextView)findViewById(R.id.letra6);

        //asignar font a lblElegirLetra
        TextView lblElegirLetra=(TextView)findViewById(R.id.lblElegirLetra);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/GoodDog.otf");
        lblElegirLetra.setTypeface(typeFace);
        lblElegirLetra.setText("Elija una letra "+ nombre + "!");

        // guardar editText
        letra = (EditText)findViewById(R.id.letra);

        //asignar font a lblFallidas
        lblFallidas=(TextView)findViewById(R.id.lblFallidas);
        lblFallidas.setTypeface(typeFace);

        //Asignar font a boton
        Button btnOk=(Button)findViewById(R.id.boton_ok);
        btnOk.setTypeface(typeFace);

        imagen=(ImageView)findViewById(R.id.imagen);
        imagen.setImageResource(R.drawable.hangman1);
    }

    public void clickBotonOK(View v){
        String letraElegida = letra.getText().toString();
        int indice = palabraAAdivinar.indexOf(letraElegida);
        if(indice!=-1){
            setLetra(indice,letraElegida);
        }else{
            maximoPuntaje=maximoPuntaje-10;
            lblFallidas.setText(lblFallidas.getText()+" " + letraElegida + " -");
            intentos++;
            cambiarImagen(intentos);
        }
    }

    public void cambiarImagen (int turno){
        imagen=(ImageView)findViewById(R.id.imagen);
        switch (turno){
            case 1:
                imagen.setImageResource(R.drawable.hangman2);
                break;
            case 2:
                imagen.setImageResource(R.drawable.hangman3);
                break;
            case 3:
                imagen.setImageResource(R.drawable.hangman4);
                break;
            case 4:
                imagen.setImageResource(R.drawable.hangman5);
                break;
            case 5:
                imagen.setImageResource(R.drawable.hangman6);
                break;
            case 6:
                imagen.setImageResource(R.drawable.hangman7);
                break;

        }
    }

    public void setLetra (int indice, String contenido){
        switch (indice){
            case 0:
                letra1.setText(contenido);
                break;
            case 1:
                letra2.setText(contenido);
                break;
            case 2:
                letra3.setText(contenido);
                break;
            case 3:
                letra4.setText(contenido);
                break;
            case 4:
                letra5.setText(contenido);
                break;
            case 5:
                letra6.setText(contenido);
                break;

        }
    }
}
