package com.example.competicionessql.controladores;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.clases.FotoEscuderia;
import com.example.competicionessql.tareas.TareaObtenerFotosEscuderias;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FotoEscuderiaController {


    public static ArrayList<FotoEscuderia> obtenerFotosEscuderias() {
        ArrayList<FotoEscuderia> fotoEscuderias = null;
        FutureTask t = new FutureTask (new TareaObtenerFotosEscuderias(100,100));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);

        try {
            fotoEscuderias= (ArrayList<FotoEscuderia>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fotoEscuderias;
    }
}
