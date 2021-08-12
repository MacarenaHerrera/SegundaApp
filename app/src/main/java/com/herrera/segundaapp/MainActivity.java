package com.herrera.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button enviar;
    private EditText ETSalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista();

        if((Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
                && (checkSelfPermission(Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)){
            requestPermissions(new String[]{Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_CONTACTS},1500);
        }

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},1500);
        }

    }

    private void inicializarVista() {
        enviar = findViewById(R.id.BTSiguiente1);
        ETSalida = findViewById(R.id.etComplete);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActividadSiguiente.class);
                i.putExtra("msg", ETSalida.getText().toString());
                startActivity(i);
            }

        });




    }



}