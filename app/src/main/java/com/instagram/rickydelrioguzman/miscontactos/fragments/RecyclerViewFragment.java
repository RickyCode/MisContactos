package com.instagram.rickydelrioguzman.miscontactos.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.instagram.rickydelrioguzman.miscontactos.R;
import com.instagram.rickydelrioguzman.miscontactos.adapter.ContactoAdaptador;
import com.instagram.rickydelrioguzman.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    
    private RecyclerView listaContactos;
    static public ArrayList<Contacto> contactos;
    
    public void inicializarListaContactos() {
        contactos = new ArrayList<Contacto>();
        // Población de la lista:
        contactos.add(new Contacto(R.drawable.blank_profile, "Ricardo Del Río", "77779999", "ricky@mail.com"));
        contactos.add(new Contacto(R.drawable.shadow ,"Pedro Sanchez", "88882222", "algo@otroalgo.com"));
        contactos.add(new Contacto(R.drawable.eyes ,"Mireya Martinez", "33331111", "algo@otroalgo.com"));
        contactos.add(new Contacto(R.drawable.violet_blue ,"Juan Lopez", "44442222", "algo@otroalgo.com"));
        contactos.add(new Contacto(R.drawable.blank_profile ,"Anita Morales", "12341234", "algo@otroalgo.com"));
        contactos.add(new Contacto(R.drawable.cat ,"Javiera Soto", "56785678", "algo@otroalgo.com"));
        
    }
    
    public void inicializarAdapador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Asociación del código java con el formato XML
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false); // Equivale al "setContentView"  de una activity
        
        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
    
        // Forma en que se muestra el "RecyclerView":
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        
//        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
//        listaContactos.setLayoutManager(glm);
        
        inicializarListaContactos();
        inicializarAdapador();
    
        return v;
    }
    
}
