package com.hermesis.christian.practica11;

import android.content.Context;
import android.media.Rating;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Christian on 14/05/2018.
 */

public class adaptador_recicler extends RecyclerView.Adapter<adaptador_recicler.ViewHolderArtista>{

    private final Context context;
    private List<artista> datos;

    public adaptador_recicler(Context context, List<artista> datos) {
        this.context = context;
        this.datos = datos;
    }

    @Override
    public ViewHolderArtista onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        return new ViewHolderArtista(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderArtista holder, int position) {

        artista artista = datos.get(position);
        holder.txtnombre.setText(artista.getName());
        holder.textTelefono.setText(artista.getPhone());
        holder.ratingBar.setRating((float)artista.getRating());
        if (artista.checarImagen()){

        }
        else{
            holder.cimagen.setImageResource(R.drawable.persona);
        }

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolderArtista extends RecyclerView.ViewHolder{

        @BindView(R.id.Silueta)
        TextView txtnombre;
        @BindView(R.id.rating)
        RatingBar ratingBar;
        @BindView(R.id.telefono)
        TextView textTelefono;
        @BindView(R.id.avatar)
        CircleImageView cimagen;




        public ViewHolderArtista(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
