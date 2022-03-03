package com.example.competicionessql.controladores;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.tareas.TareaBorrarEscuderia;
import com.example.competicionessql.tareas.TareaInsertarEscuderia;
import com.example.competicionessql.tareas.TareaObtenerEscuderias;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class EscuderiaController {

    public static ArrayList<Escuderias> obtenerEscuderia() {
        ArrayList<Escuderias> escuderiasDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerEscuderias());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            escuderiasDevueltas= (ArrayList<Escuderias>)t.get();
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
        return escuderiasDevueltas;
    }

    //---------------------------------------------------------------------------

    public static boolean InsertarEscuderia(Escuderias c){
        FutureTask t = new FutureTask(new TareaInsertarEscuderia(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
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
        finally {
            return insercionOK;
        }
    }

    //------------------------------------------------------------------------------------
    public static boolean borrarEscuderia(Escuderias escseleccionada) {
        FutureTask t = new FutureTask(new TareaBorrarEscuderia(escseleccionada));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
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
        finally {
            return borradoOK;
        }
    }
}
