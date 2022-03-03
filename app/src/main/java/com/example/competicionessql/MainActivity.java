package com.example.competicionessql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nuevoCampeonato(View view) {
        Intent intent = new Intent(this, NuevoCampeonato.class);
        startActivity(intent);
    }

    public void actualizarCampeonato(View view) {
        Intent intent = new Intent(this, ActualizarCampeonato1.class);
        startActivity(intent);
    }

    public void borrarCampeonato(View view) {
        Intent intent = new Intent(this, BorrarCampeonato.class);
        startActivity(intent);
    }

    public void mostrarEscuderias(View view) {
        Intent intent = new Intent(this, MostrarEscuderias.class);
        startActivity(intent);
    }
}