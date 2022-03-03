package com.example.competicionessql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.clases.EscuderiaViewHolder;


public class MostrarDetalleEscuderias extends AppCompatActivity {


    TextView txt_nombreEscuderiaDetalle = null;
    TextView txt_anoFundadaDetalle = null;
    TextView txt_paisDetalle = null;
    TextView txt_campeonatoDetalle = null;
    ImageView imagenEscuderia = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle_escuderias);
        txt_nombreEscuderiaDetalle = findViewById(R.id.txt_nomEscuderiaDetalle);
        txt_anoFundadaDetalle = findViewById(R.id.txt_anoFundadaDetalle);
        txt_paisDetalle= findViewById(R.id.txt_paisDetalle);
        txt_campeonatoDetalle = findViewById(R.id.txt_CampeonatoDetalle);
        imagenEscuderia = findViewById(R.id.imagenEscuderia);
        Intent intent = getIntent();
        if(intent !=null){
            Escuderias e = (Escuderias) intent.getSerializableExtra(NuevaEscuderia.EXTRA_OBJETO_ESCUDERIA);
            txt_nombreEscuderiaDetalle.setText(e.getNombre());
            txt_anoFundadaDetalle.setText("Año fundada: " + String.valueOf(e.getFundadaAno()));
            txt_paisDetalle.setText(e.getPais());
            txt_campeonatoDetalle.setText("IdCampeonato: " + String.valueOf(e.getCampeonato()));
        }
    }
}