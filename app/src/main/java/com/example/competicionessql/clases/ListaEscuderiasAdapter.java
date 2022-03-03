package com.example.competicionessql.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.competicionessql.MostrarEscuderias;
import com.example.competicionessql.R;

import java.util.ArrayList;

public class ListaEscuderiasAdapter extends RecyclerView.Adapter<EscuderiaViewHolder> {

    private Context c;
    private ArrayList<Escuderias> listaEscuderias;
    private ArrayList<FotoEscuderia> listaFotosEscuderia;
    private LayoutInflater mInflater;

    public ListaEscuderiasAdapter(Context c, ArrayList<Escuderias> escuderias, ArrayList<FotoEscuderia> fotosEscuderia) {
        this.c = c;
        this.listaEscuderias = escuderias;
        this.listaFotosEscuderia = fotosEscuderia;
        mInflater = LayoutInflater.from(c);
    }

    public ArrayList<FotoEscuderia> getListaFotosEscuderia(){ return listaFotosEscuderia; }

    public void setListaFotosEscuderia (ArrayList<FotoEscuderia> listaFotosEscuderia){
        this.listaFotosEscuderia = listaFotosEscuderia;
    }

    @NonNull
    @Override
    public EscuderiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_escuderia, parent, false);
        return new EscuderiaViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull EscuderiaViewHolder holder, int position) {
        Escuderias escuderiaActual = listaEscuderias.get(position);
        holder.txt_rv_nombreEsc.setText("Escuderia: " + escuderiaActual.getNombre());
        holder.txt_rv_anoFundada.setText(String.valueOf("Año Fundada: " + escuderiaActual.getFundadaAno()));
        holder.txt_rv_campeonato.setText("Campeonato: " + escuderiaActual.getCampeonato());
        holder.txt_rv_pais.setText(("Pais: " + escuderiaActual.getPais()));
        if(this.listaFotosEscuderia !=null){
            for (FotoEscuderia fe: this.listaFotosEscuderia) {
                if(fe.getIdescuderia()== escuderiaActual.getIdEscuderias()){
                    holder.img_escuderia.setImageBitmap(fe.getFoto());
                    break;
                }

            }
        }
    }

    @Override
    public int getItemCount() {
        return listaEscuderias.size();
    }

    public Context getC(){return c;}
    public void setC(Context c){this.c = c;}
    public ArrayList<Escuderias> getListaEscuderias(){return listaEscuderias;}
    public void setListaEscuderias(ArrayList<Escuderias> listaEscuderias){
        this.listaEscuderias = listaEscuderias;
    }


}
