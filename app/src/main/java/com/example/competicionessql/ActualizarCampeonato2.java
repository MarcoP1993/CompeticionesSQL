package com.example.competicionessql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.controladores.CampeonatoController;

import java.util.ArrayList;

public class ActualizarCampeonato2 extends AppCompatActivity {

    Campeonato campSeleccionado = null;
    EditText edt_idCampeonato = null;
    EditText edt_nomCampeonato = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_campeonato2);
        edt_idCampeonato = (EditText) findViewById(R.id.edt_idCampeonato);
        edt_nomCampeonato = (EditText) findViewById(R.id.edt_nomCampeonato);
        Intent intent = getIntent();
        if(intent !=null){
            campSeleccionado = (Campeonato) intent.getSerializableExtra(ActualizarCampeonato1.EXTRA_OBJETO_CAMPEONATO);
            if(campSeleccionado !=null){
                edt_idCampeonato.setText(String.valueOf(campSeleccionado.getIdCampeonato()));
                edt_idCampeonato.setEnabled(false);
                edt_nomCampeonato.setText(campSeleccionado.getNombre());
            }
        }
    }

    public void actualizarCampeonato(View view) {

        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Seguro que quieres actualizar el Campeonato?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int idcampeonato = Integer.valueOf(String.valueOf(edt_idCampeonato.getText()));
                String nombreCampeonato = String.valueOf(edt_nomCampeonato.getText());
                Campeonato c = new Campeonato(idcampeonato,nombreCampeonato);
                boolean actualizarOk = CampeonatoController.actualizarCampeonato(c);
                if(actualizarOk){
                    ActualizarCampeonato1.adapter.clear();
                    ArrayList<Campeonato> campeonato = CampeonatoController.obtenerCampeonato();
                    ActualizarCampeonato1.adapter.addAll(campeonato);
                    mostrarToast("Campeonato Actualizado");
                }else{
                    mostrarToast("NO se ha podido actualizar el campeonato");
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

    private void mostrarToast(String mensaje) {
        Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show();
    }
}