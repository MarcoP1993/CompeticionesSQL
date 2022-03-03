package com.example.competicionessql.clases;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.competicionessql.MostrarDetalleEscuderias;
import com.example.competicionessql.R;

import java.util.Objects;
import static com.example.competicionessql.NuevaEscuderia.EXTRA_OBJETO_ESCUDERIA;

public class EscuderiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txt_rv_nombreEsc = null;
    public TextView txt_rv_anoFundada = null;
    public  TextView txt_rv_campeonato = null;
    public  TextView txt_rv_pais = null;
    public ImageView img_escuderia = null;

    final ListaEscuderiasAdapter leAdapter;

    public EscuderiaViewHolder(@NonNull View itemView, ListaEscuderiasAdapter mAdapter) {

        super(itemView);
        txt_rv_nombreEsc = (TextView) itemView.findViewById(R.id.txt_rv_nombreEsc);
        txt_rv_anoFundada = (TextView) itemView.findViewById(R.id.txt_rv_anoFundada);
        txt_rv_campeonato = (TextView) itemView.findViewById(R.id.txt_rv_campeonato);
        txt_rv_pais = (TextView) itemView.findViewById(R.id.txt_rv_pais);
        img_escuderia = (ImageView) itemView.findViewById(R.id.img_escuderia);
        this.leAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int mPosition = getLayoutPosition();
        Escuderias escuderias = this.leAdapter.getListaEscuderias().get(mPosition);

        leAdapter.notifyDataSetChanged();
        Intent intent = new Intent(leAdapter.getC(), MostrarDetalleEscuderias.class);
        intent.putExtra(EXTRA_OBJETO_ESCUDERIA, escuderias);
        leAdapter.getC().startActivity(intent);
    }
}
