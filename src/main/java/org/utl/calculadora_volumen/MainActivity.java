package org.utl.calculadora_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(View -> {
            Intent abrirSegundaVista = new Intent(this, MainActivity2.class);
            startActivity(abrirSegundaVista);
        });
    }




}