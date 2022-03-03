package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.modelos.EscuderiaDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerEscuderias implements Callable<ArrayList<Escuderias>> {

    @Override
    public ArrayList<Escuderias> call() throws Exception {
        ArrayList<Escuderias> escuderias = EscuderiaDB.obtenerEscuderias();
        return escuderias;
    }
}
