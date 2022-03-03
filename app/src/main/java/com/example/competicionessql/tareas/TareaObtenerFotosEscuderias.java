package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.FotoEscuderia;
import com.example.competicionessql.modelos.EscuderiaDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerFotosEscuderias implements Callable<ArrayList<FotoEscuderia>> {

    private int height;
    private int width;

    public TareaObtenerFotosEscuderias(int width, int height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public ArrayList<FotoEscuderia> call() throws Exception {
        ArrayList<FotoEscuderia> fotoEscuderias = EscuderiaDB.obtenerFotosEscuderia(this.width, this.height);
        return fotoEscuderias;
    }
}
