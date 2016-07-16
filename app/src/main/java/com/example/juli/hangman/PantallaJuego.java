package com.example.juli.hangman;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

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
    boolean musicaOn;
    ImageView imagen;
    int letrasAdivinadas;
    MediaPlayer mPlayer;
    ImageButton music;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);
        mPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.cancion);
        music = (ImageButton) findViewById(R.id.btnSonido);
        mPlayer.start();
        musicaOn=true;
        maximoPuntaje = 60;
        intentos = 0;
        letrasAdivinadas = 0;
        Intent intent = getIntent();
        nombre = intent.getStringExtra("NOMBRE");
        puntaje = intent.getIntExtra("PUNTAJE",0);
        int indice = new Random().nextInt(15);
        palabraAAdivinar = palabras[indice];

        //obtener elementos de letras
        letra1 = (TextView) findViewById(R.id.letra1);
        letra2 = (TextView) findViewById(R.id.letra2);
        letra3 = (TextView) findViewById(R.id.letra3);
        letra4 = (TextView) findViewById(R.id.letra4);
        letra5 = (TextView) findViewById(R.id.letra5);
        letra6 = (TextView) findViewById(R.id.letra6);

        //asignar font a lblElegirLetra
        TextView lblElegirLetra = (TextView) findViewById(R.id.lblElegirLetra);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/GoodDog.otf");
        lblElegirLetra.setTypeface(typeFace);
        lblElegirLetra.setText(lblElegirLetra.getText()+" " + nombre + "!");


        //asignar font a lblFallidas
        lblFallidas = (TextView) findViewById(R.id.lblFallidas);
        lblFallidas.setTypeface(typeFace);


        imagen = (ImageView) findViewById(R.id.imagen);
        imagen.setImageResource(R.drawable.hangman1);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void clickBotonOK(View v) {
        Button letra = (Button) findViewById(v.getId());
        String letraElegida = letra.getText().toString();
        deshabilitarBoton(letra);
        boolean encontrado = false;
        int indice = palabraAAdivinar.indexOf(letraElegida);
        while (indice != -1) {
            encontrado = true;
            setLetra(indice, letraElegida);
            indice = palabraAAdivinar.indexOf(letraElegida, indice + 1);
            letrasAdivinadas++;
        }
        if (!encontrado) {
            maximoPuntaje = maximoPuntaje - 10;
            lblFallidas.setText(lblFallidas.getText() + " " + letraElegida + " -");
            intentos++;
            cambiarImagen(intentos);
        }
        if (letrasAdivinadas == 6) {

            Toast toast = getToast(getResources().getText(R.string.ganaste).toString());
            toast.show();
            finalizar();
        } else {
            if (intentos == 6) {
                Toast toast = getToast(getResources().getText(R.string.perdiste).toString());
                toast.show();
                finalizar();
            }
        }

    }

    private void deshabilitarBoton(Button letra) {
        letra.setClickable(false);
        letra.setBackgroundColor(Color.YELLOW);
    }

    private void finalizar() {
        Intent juegofinal=new Intent(this, PantallaFinal.class);
        juegofinal.putExtra("PUNTAJE",maximoPuntaje+puntaje);
        juegofinal.putExtra("NOMBRE", nombre);
        mPlayer.stop();
        startActivity(juegofinal);
        this.finish();
    }

    @NonNull
    private Toast getToast(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.setBackgroundResource(R.drawable.button3d);
        return toast;
    }

    public void cambiarImagen(int turno) {
        imagen = (ImageView) findViewById(R.id.imagen);
        switch (turno) {
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

    public void setLetra(int indice, String contenido) {
        switch (indice) {
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

    public void musica(View v){

        if(musicaOn){
            mPlayer.pause();
            music.setBackgroundResource(R.drawable.sonido_off);
            musicaOn=false;
        }else{
            mPlayer.start();
            music.setBackgroundResource(R.drawable.sonido_on);
            musicaOn=true;
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PantallaJuego Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.juli.hangman/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PantallaJuego Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.juli.hangman/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
