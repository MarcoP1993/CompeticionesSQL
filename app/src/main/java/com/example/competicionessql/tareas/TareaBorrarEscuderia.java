package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.modelos.EscuderiaDB;

import java.util.concurrent.Callable;

public class TareaBorrarEscuderia implements Callable<Boolean> {
    private Escuderias c =null;

    public TareaBorrarEscuderia(Escuderias escseleccionada) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOk = EscuderiaDB.borrarEscuderiaTabla(c);
        return null;
    }
}
