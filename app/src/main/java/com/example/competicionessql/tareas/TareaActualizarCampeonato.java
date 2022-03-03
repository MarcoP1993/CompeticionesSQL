package com.example.competicionessql.tareas;

import com.example.competicionessql.clases.Campeonato;
import com.example.competicionessql.modelos.CampeonatoDB;

import java.util.concurrent.Callable;

public class TareaActualizarCampeonato implements Callable<Boolean> {
    private Campeonato c = null;

    public TareaActualizarCampeonato(Campeonato c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean actualizadoOk = CampeonatoDB.actualizarCampeonatoTabla(c);
        return actualizadoOk;
    }
}
