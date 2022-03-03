package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.modelos.CampeonatoDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerCampeonato implements Callable<ArrayList<Campeonato>> {

    @Override
    public ArrayList<Campeonato> call() throws Exception {
        ArrayList<Campeonato> campeonatos = CampeonatoDB.obtenerCampeonatos();
        return campeonatos;
    }
}
