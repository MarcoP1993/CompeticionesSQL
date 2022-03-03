package com.example.competicionessql.clases;

import java.io.Serializable;

public class Campeonato implements Serializable {

    private int idCampeonato;
    private String nombre;


    public Campeonato( String nombre) {

        this.nombre = nombre;
    }

    public Campeonato(int idCampeonato, String nombre) {
        this.idCampeonato = idCampeonato;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campeonato)) return false;
        Campeonato campeonato = (Campeonato) o;
        return idCampeonato == campeonato.idCampeonato;
    }

    public int getIdCampeonato() {
        return this.idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {

        return nombre;
    }


}

