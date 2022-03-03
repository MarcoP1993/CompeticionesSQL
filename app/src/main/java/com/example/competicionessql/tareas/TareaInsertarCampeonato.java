package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.modelos.CampeonatoDB;

import java.util.concurrent.Callable;

public class TareaInsertarCampeonato implements Callable<Boolean> {

    private Campeonato c = null;

    public TareaInsertarCampeonato(Campeonato c) {
        this.c = c;
    }

    public Boolean call() throws Exception{
        boolean insertadoOk = CampeonatoDB.insertarCampeonatoTabla(c);
        return insertadoOk;
    }
}
