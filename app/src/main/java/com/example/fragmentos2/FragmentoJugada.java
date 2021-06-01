package com.example.fragmentos2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentoJugada extends Fragment {

    TextView textoJugada;

    public FragmentoJugada() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_jugada,
                container, false);
        textoJugada=v.findViewById(R.id.textoMostrarJugada);

        v.findViewById(R.id.botonJugada).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botonPulsado(view);

            }
        });
        return v;
    }

    public int generarRamdom(){

        return (int)(Math.random()*9);
    }

    public String generarJugada(){
        String resultado;

        resultado=String.valueOf(generarRamdom())+String.valueOf(generarRamdom());
        return resultado;
    }

    public interface CuandoPulseBotonListener {
        public void hanPulsadoElBoton();
    }
    CuandoPulseBotonListener elManejador;

    public void estableceManejadorEvento(CuandoPulseBotonListener manejador){
        elManejador = manejador;
    }
    public void botonPulsado(View view){
        if(elManejador != null){
            textoJugada.setText(generarJugada());
            elManejador.hanPulsadoElBoton();

        }

    }

}