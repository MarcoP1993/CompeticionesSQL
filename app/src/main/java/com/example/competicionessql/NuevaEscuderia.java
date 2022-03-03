package com.example.competicionessql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.controladores.CampeonatoController;
import com.example.competicionessql.controladores.EscuderiaController;

import java.util.ArrayList;

public class NuevaEscuderia extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_ESCUDERIA = "com.example.NuevaEscuderia.escideria";
    Spinner spinner_nuevoCampeonato =null;
    Campeonato camSelecccionado=null;
    ArrayAdapter<Campeonato> adapter=null;
    ArrayList<Campeonato> campeonatos=null;
    EditText edt_nombreEscuderia=null;
    EditText edt_fundadaAno=null;
    EditText edt_pais=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_escuderia);
        edt_nombreEscuderia = findViewById(R.id.edt_nombreEscuderia);
        edt_fundadaAno = findViewById(R.id.edt_fundada);
        edt_pais = findViewById(R.id.edt_paisEscuderia);
        spinner_nuevoCampeonato = (Spinner) findViewById(R.id.sp_campeonato);
        if(spinner_nuevoCampeonato !=null){
            spinner_nuevoCampeonato.setOnItemSelectedListener(this);
            campeonatos = CampeonatoController.obtenerCampeonato();
            if(campeonatos != null){
                adapter = new ArrayAdapter<Campeonato>(this, R.layout.item_campeonato, campeonatos);
                spinner_nuevoCampeonato.setAdapter(adapter);
            }

        }
    }

    public void mostrarToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void nuevaEscuderia(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Quieres guardar la escuderia?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(camSelecccionado == null){
                    mostrarToast("Selecciona un campeonato");
                    return;
                }
                Escuderias esc;
                try{
                    String nombre = String.valueOf(edt_nombreEscuderia.getText());
                    int FundadaAno = Integer.valueOf(String.valueOf(edt_fundadaAno.getText()));
                    int idCampeonato = Integer.valueOf(String.valueOf(camSelecccionado.getIdCampeonato()));
                    String pais = String.valueOf(edt_pais.getText());
                    esc = new Escuderias(nombre, FundadaAno, idCampeonato, pais);
                    boolean insertadoOk = EscuderiaController.InsertarEscuderia(esc);
                    if(insertadoOk)
                    {
                        mostrarToast("ciudad insertada correctamente");
                        Intent intent = new Intent();
                        intent.putExtra(EXTRA_OBJETO_ESCUDERIA, esc);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    else{
                        mostrarToast("no se pudo crear la escuderia");
                    }
                }catch (Exception e){
                    mostrarToast("ERROR, revisa los datos");
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        Campeonato campeonato = (Campeonato) spinner_nuevoCampeonato.getItemAtPosition(position);
        camSelecccionado = campeonato;
    }

    @Override
    public void onNothingSelected (AdapterView<?> parent){

    }
}