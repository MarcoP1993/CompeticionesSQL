package com.example.competicionessql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.controladores.CampeonatoController;

import java.util.ArrayList;

public class ActualizarCampeonato1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_CAMPEONATO = "com.example.ActualizarActivity1.campeonato";
    Spinner sp_campActualizar= null;
    static Campeonato campSeleccionado = null;
    static ArrayAdapter<Campeonato> adapter = null;
    ArrayList<Campeonato> campeonato = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_campeonato1);
        sp_campActualizar = (Spinner) findViewById(R.id.sp_campActualizar);
        if(sp_campActualizar !=null){
            sp_campActualizar.setOnItemSelectedListener(this);
            campeonato = CampeonatoController.obtenerCampeonato();
            if(campeonato != null){
                adapter = new ArrayAdapter<Campeonato>(this, R.layout.item_campeonato, campeonato);
                sp_campActualizar.setAdapter(adapter);
            }
        }
    }


    public void Actualizarsiguiente(View view) {
        Intent intent = new Intent(this, ActualizarCampeonato2.class);
        intent.putExtra(EXTRA_OBJETO_CAMPEONATO, campSeleccionado);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Campeonato c = (Campeonato) sp_campActualizar.getItemAtPosition(position);
        campSeleccionado = c;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}