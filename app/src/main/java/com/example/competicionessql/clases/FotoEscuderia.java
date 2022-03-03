package com.example.competicionessql.clases;

import android.graphics.Bitmap;

public class FotoEscuderia {
    private int idfoto;
    private Bitmap foto;
    private int idescuderia;

    public FotoEscuderia(int idfoto, Bitmap foto, int idescuderia) {
        this.idfoto = idfoto;
        this.foto = foto;
        this.idescuderia = idescuderia;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public int getIdescuderia() {
        return idescuderia;
    }

    public void setIdescuderia(int idescuderia) {
        this.idescuderia = idescuderia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FotoEscuderia that = (FotoEscuderia) o;

        return idfoto == that.idfoto &&
                idescuderia == that.idescuderia &&
                foto.equals(that.foto);
    }

    @Override
    public String toString() {
        return "FotoEscuderia{" +
                "idfoto=" + idfoto +
                ", foto=" + foto +
                ", idescuderia=" + idescuderia +
                '}';
    }
}
