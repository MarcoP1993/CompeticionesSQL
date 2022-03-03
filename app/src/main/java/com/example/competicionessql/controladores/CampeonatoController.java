package com.example.competicionessql.controladores;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.tareas.TareaActualizarCampeonato;
import com.example.competicionessql.tareas.TareaBorrarCampeonato;
import com.example.competicionessql.tareas.TareaInsertarCampeonato;
import com.example.competicionessql.tareas.TareaObtenerCampeonato;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CampeonatoController {

    public static boolean insertarCampeonato(Campeonato c) {
        FutureTask t = new FutureTask(new TareaInsertarCampeonato(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOk = false;
        try{
            insercionOk = (boolean) t.get();
            es.shutdown();
            try{
                if(!es.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                    es.shutdownNow();
                }
            }catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOk;
        }
    }

    //------------------------------------------------------------------------------

    public static ArrayList<Campeonato> obtenerCampeonato() {

        ArrayList<Campeonato> campeonatosDevueltos = null;
        FutureTask t = new FutureTask(new TareaObtenerCampeonato());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try{
            campeonatosDevueltos = (ArrayList<Campeonato>)t.get();
            es.shutdown();
            try{
                if(!es.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                    es.shutdownNow();
                }
            }catch (InterruptedException e){
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return campeonatosDevueltos;
    }

    //------------------------------------------------------------------------------

    public static boolean borrarCampeonato(Campeonato c) {
        FutureTask t = new FutureTask( new TareaBorrarCampeonato(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
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
            return borradoOK;
        }
    }

    public static boolean actualizarCampeonato(Campeonato c) {
        FutureTask t = new FutureTask(new TareaActualizarCampeonato(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
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
            return actualizadoOK;
        }
    }

    //------------------------------------------------------------------------------

}
