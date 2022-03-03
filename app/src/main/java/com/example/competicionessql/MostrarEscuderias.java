package com.example.competicionessql;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.clases.FotoEscuderia;
import com.example.competicionessql.clases.ListaEscuderiasAdapter;
import com.example.competicionessql.controladores.EscuderiaController;
import com.example.competicionessql.controladores.FotoEscuderiaController;

import java.util.ArrayList;
import java.util.Collections;

public class MostrarEscuderias extends AppCompatActivity {

    private static final int PETICION1 = 1;
    private RecyclerView recyclerView;
    private ListaEscuderiasAdapter mAdapter;
    private ArrayList<Escuderias> escuderias;
    private ArrayList<FotoEscuderia> fotosEscuderia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_escuderias);

        escuderias = EscuderiaController.obtenerEscuderia();
        fotosEscuderia = FotoEscuderiaController.obtenerFotosEscuderias();
        if(escuderias != null){
            recyclerView = findViewById(R.id.recycler_Escuderias);
            mAdapter = new ListaEscuderiasAdapter(this, escuderias, fotosEscuderia);
            recyclerView.setAdapter(mAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    int from = viewHolder.getAdapterPosition();
                    int to = target.getAdapterPosition();
                    Collections.swap(escuderias, from, to);
                    mAdapter.notifyItemRangeRemoved(from, to);
                    return true;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    if(direction == ItemTouchHelper.LEFT){
                        mostrarToast("Has pulsado izquierda");
                        escuderias.remove(viewHolder.getAdapterPosition());
                        mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
                    if(direction == ItemTouchHelper.RIGHT)
                    {
                        mostrarToast("ha pulsado derecha");
                        escuderias.remove(viewHolder.getAdapterPosition());
                        mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
                }
            });
            helper.attachToRecyclerView((recyclerView));
        }else{
            mostrarToast("NO se pudo establecer conexion con la base de datos");
        }

    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PETICION1){
            if(resultCode == RESULT_OK){
                Escuderias e = (Escuderias) data.getSerializableExtra(NuevaEscuderia.EXTRA_OBJETO_ESCUDERIA);
                escuderias.add(e);
                recyclerView.getAdapter().notifyItemInserted(escuderias.size());
                recyclerView.smoothScrollToPosition(escuderias.size());
            }
        }
    }

    public void refrescarEscuderia(View view) {
        escuderias = EscuderiaController.obtenerEscuderia();
        if(escuderias !=null){
            mAdapter.setListaEscuderias(escuderias);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void NuevaCiudad(View view) {
        Intent intent = new Intent(this, NuevaEscuderia.class);
        startActivityForResult(intent, PETICION1);
    }
}