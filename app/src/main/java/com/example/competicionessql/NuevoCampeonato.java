package com.example.competicionessql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.controladores.CampeonatoController;

public class NuevoCampeonato extends AppCompatActivity {

    EditText edt_nombreCamp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_campeonato);
        edt_nombreCamp = findViewById(R.id.edt_nombre_campeonato);
    }

    public void crearCampeonato(View view) {
        String nombreCamp = String.valueOf(edt_nombreCamp.getText());
        if(nombreCamp.isEmpty()){
            edt_nombreCamp.setError("Escribe un nombre para el campeonato");
            return;
        }
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Quieres guardar el campeonato?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Campeonato c = new Campeonato(nombreCamp);
                boolean insercionOk = CampeonatoController.insertarCampeonato(c);
                mostrartoast(insercionOk);
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();

    }

    private void mostrartoast(boolean insercionOk) {
        if(insercionOk){
            Toast.makeText(this,"Campeonato guardado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
        }
    }
}