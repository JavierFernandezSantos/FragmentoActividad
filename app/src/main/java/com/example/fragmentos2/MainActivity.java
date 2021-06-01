package com.example.fragmentos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentoJugada.CuandoPulseBotonListener{

    FragmentoJugada fragJugada;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragJugada= (FragmentoJugada)
                getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        textoResultado=findViewById(R.id.textoResultado);
        fragJugada.estableceManejadorEvento(this);
    }

    @Override
    public void hanPulsadoElBoton() {
        String op;
        op=fragJugada.textoJugada.getText().toString();
        switch(op){

            case "00":
                textoResultado.setText("GOL");
                break;
            case "03":
                textoResultado.setText("FALTA");
                break;
            case "59":
                textoResultado.setText("PENALTI");
                break;
            default:
                textoResultado.setText("NADA");

        }
    }
}