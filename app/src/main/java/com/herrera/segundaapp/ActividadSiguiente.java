package com.herrera.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActividadSiguiente extends AppCompatActivity {
    private TextView text;
    private Button enviar2;
    private TextView TVFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_siguiente);
        ObtenerValue();
        inicializarVista();

    }
    private void ObtenerValue() {
        text = findViewById(R.id.ETSalida);
        String msg = getIntent().getStringExtra("msg");
        text.setText(msg);
    }

    private void inicializarVista() {
        enviar2 = findViewById(R.id.BTSiguiente2);
        enviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActividadSiguiente.this, ActividadFinal.class);
                startActivity(i);
            }

        });

    }
}