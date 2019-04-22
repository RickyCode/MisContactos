package com.instagram.rickydelrioguzman.miscontactos.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import com.instagram.rickydelrioguzman.miscontactos.pojo.Contacto;
import com.instagram.rickydelrioguzman.miscontactos.DetalleContacto;
import com.instagram.rickydelrioguzman.miscontactos.R;

import java.util.ArrayList;


public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;


    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Inflar el layout y lo pasará al "viewHolder" para que obtenga los "Views"
        //Le damos vida al layout "cardview_contacto": (layoout que se reciclará)
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contacto, viewGroup, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final @NonNull ContactoViewHolder contactoViewHolder, final int position) {
        //asocia cada elemento de la lista con cada view
        final Contacto contacto = contactos.get(position); //Se invoca por cada elemento
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(contacto.getLikes()+ " Likes");

        contactoViewHolder.itemCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Abriste: " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("POSICION", position);
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contacto.setLikes(contacto.getLikes()+1);
                contactoViewHolder.tvLikes.setText(contacto.getLikes()+ " Likes");
                String texto = "Diste like a: " + contacto.getNombre();
                Toast.makeText(activity, texto, Toast.LENGTH_SHORT).show();
            }
        });
        
        

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return contactos.size();
    }


    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private View itemCardView;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCardView = itemView;
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike      = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes      = itemView.findViewById(R.id.tvLikesCV);
        }
    }

}
