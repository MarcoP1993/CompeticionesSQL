package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.modelos.CampeonatoDB;

import java.util.concurrent.Callable;

public class TareaBorrarCampeonato implements Callable<Boolean> {
    private Campeonato c=null;

    public TareaBorrarCampeonato(Campeonato c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOk = CampeonatoDB.borrarCampeonatoTabla(c);
        return borradoOk;
    }
}
