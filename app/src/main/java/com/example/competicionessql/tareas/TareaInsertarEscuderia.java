package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.modelos.EscuderiaDB;

import java.util.concurrent.Callable;

public class TareaInsertarEscuderia implements Callable<Boolean> {
    private Escuderias c = null;

    public TareaInsertarEscuderia(Escuderias c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertarOk = EscuderiaDB.insertarEscuderiaTabla(c);
        return insertarOk;
    }
}
