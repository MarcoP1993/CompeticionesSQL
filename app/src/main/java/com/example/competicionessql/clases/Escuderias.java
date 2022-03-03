package com.example.competicionessql.clases;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Escuderias implements Serializable {
    private int idEscuderias;
    private int campeonato;
    private String nombre;
    private int fundadaAno;
    private byte[] imagen;
    private String pais;

    public Escuderias(int idEscuderias, String nombre, int fundadaAno, int idCampeonato, String pais) {
        this.idEscuderias = idEscuderias;
        this.nombre = nombre;
        this.fundadaAno = fundadaAno;
        this.pais= pais;
    }

    public Escuderias(int campeonato, String nombre, String pais) {
        this.campeonato = campeonato;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Escuderias(String nombre, Integer fundadaAno, String pais, int campeonato) {
        this.nombre = nombre;
        this.fundadaAno = fundadaAno;
        this.pais = pais;
        this.campeonato = campeonato;
    }

    public Escuderias(){
        this.idEscuderias = 0;
        this.campeonato = 1;
        this.nombre = "";
        this.fundadaAno = 0;
        this.pais = "";
    }

    public Escuderias(String nombre, int fundadaAno, int campeonato, String pais) {
        this.nombre = nombre;
        this.fundadaAno = fundadaAno;
        this.campeonato = campeonato;
        this.pais = pais;
    }


    @Override
    public String toString() {
        return "Escuderias{" + "idEscuderias=" + idEscuderias + ", campeonato=" + campeonato + ", nombre='" + nombre +
                ", fundadaAno=" + fundadaAno + ", imagen=" + Arrays.toString(imagen) + ", pais='" + pais + '}';
    }

    public Integer getIdEscuderias() {
        return idEscuderias;
    }

    public void setIdEscuderias(Integer idEscuderias) {
        this.idEscuderias = idEscuderias;
    }

    public Integer getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Integer campeonato) {
        this.campeonato = campeonato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFundadaAno() {
        return fundadaAno;
    }

    public void setFundadaAno(Integer fundadaAno) {
        this.fundadaAno = fundadaAno;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}
