package com.example.uirecyclerview.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.uirecyclerview.Modelo.OfertaLaboral;
import com.example.uirecyclerview.R;

import java.util.ArrayList;

public class AdaptadorOfertaLaboral extends RecyclerView.Adapter<AdaptadorOfertaLaboral.ViewHolderOfertas>{
    ArrayList<OfertaLaboral> listaOfertas;
    Activity activity;

    public AdaptadorOfertaLaboral(ArrayList<OfertaLaboral> listaOfertas, Activity activity) {
        this.listaOfertas = listaOfertas;
        this.activity = activity;
    }

    @Override
    public ViewHolderOfertas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ly_ofertaslaborales,null,false);
        return new ViewHolderOfertas(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorOfertaLaboral.ViewHolderOfertas holder, int position) {
        OfertaLaboral oferta = listaOfertas.get(position);
        holder.lblNombre.setText(listaOfertas.get(position).getOfertaLaboral());
        holder.lblEmpresa.setText(listaOfertas.get(position).getEmpresa());
        holder.lblCargo.setText(listaOfertas.get(position).getCargo());
        holder.lblCorreo.setText(listaOfertas.get(position).getCorreo());
        holder.lblDescripcion.setText(listaOfertas.get(position).getDescripcion());
        Glide.with(activity)
                .load(oferta.getImagen())
                .into(holder.imgImagen);
    }

    @Override
    public int getItemCount() {
        return listaOfertas.size();
    }

    public class ViewHolderOfertas extends RecyclerView.ViewHolder {

        TextView lblNombre, lblEmpresa, lblCargo, lblCorreo, lblDescripcion;
        ImageView imgImagen;

        public ViewHolderOfertas(View itemView) {
            super(itemView);
            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblEmpresa = (TextView) itemView.findViewById(R.id.lblEmpresa);
            lblCargo = (TextView) itemView.findViewById(R.id.lblCargo);
            lblCorreo = (TextView) itemView.findViewById(R.id.lblCorreo);
            lblDescripcion = (TextView) itemView.findViewById(R.id.lblDescripcion);
            imgImagen = (ImageView) itemView.findViewById(R.id.imgImagen);
        }
    }
}
