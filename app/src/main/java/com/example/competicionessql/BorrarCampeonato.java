package com.example.competicionessql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.controladores.CampeonatoController;

import java.util.ArrayList;

public class BorrarCampeonato extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp_borrarCamp = null;
    Campeonato campeonatoSeleccionado = null;
    ArrayAdapter<Campeonato> adapter = null;
    ArrayList<Campeonato> campeonato = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_campeonato);
        sp_borrarCamp = (Spinner) findViewById(R.id.sp_borrarCamp);
        if(sp_borrarCamp !=null){
            sp_borrarCamp.setOnItemSelectedListener(this);
            campeonato = CampeonatoController.obtenerCampeonato();
            if(campeonato !=null){
                adapter = new ArrayAdapter<Campeonato>(this, R.layout.item_campeonato, campeonato);
                sp_borrarCamp.setAdapter(adapter);
            }
        }
    }

    public void mostrarToast(String mensaje){

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void borrarCampeonato(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Seguro que quieres borrar el Campeonato?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(campeonatoSeleccionado == null){
                    mostrarToast("Selecciona un Campeonato");
                    return;
                }
                //borrar Campeonato
                boolean borradoOk = CampeonatoController.borrarCampeonato(campeonatoSeleccionado);
                if(borradoOk){
                    
                    mostrarToast("Campeonato Borrado");
                    //leemos todos los campeonatos de la base de datos
                    adapter.clear();
                    campeonato = CampeonatoController.obtenerCampeonato();
                    adapter.addAll(campeonato);
                }else{
                    mostrarToast("el Campeonato NO se pudo borrar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Campeonato c = (Campeonato) sp_borrarCamp.getItemAtPosition(position);
        campeonatoSeleccionado = c;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}