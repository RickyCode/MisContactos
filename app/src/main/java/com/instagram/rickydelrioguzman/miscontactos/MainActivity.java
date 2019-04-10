package com.instagram.rickydelrioguzman.miscontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declaración de "Views" utilizadas:
    // Aquí sólo van las "Views" sobre las que se realiza alguna acción
    ListView lstContactos;
    // Declaración de variables:
    static ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


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
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        // Forma en que se muestra el "RecyclerView":
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

//        GridLayoutManager glm = new GridLayoutManager(this, 2);
//        listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdapador();




//        // Se crea un "ArrayList" con los nombres de cada contacto:
//        ArrayList<String> nombresContactos = new ArrayList<>();
//        for (Contacto contacto : contactos) {
//                nombresContactos.add(contacto.getNombre());
//
//        }

//        // Configuración de la "ListView" de contactos:
//        lstContactos = (ListView) findViewById(R.id.lstCobntactos);
//        lstContactos.setAdapter((new ArrayAdapter<String>(this,
//                                                            android.R.layout.simple_list_item_1,
//                                                            nombresContactos)));
//        // Para que c/elem de la lisrta se pueda clickear:
//        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Intent explítito:
//                // Envía la información a la otra activity
//                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
//                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
//                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
//                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
//                Log.i("*******CONTACTO:*******", contactos.get(position).toString());
//                startActivity(intent);
//                finish();  //Cierra esta "activity" para que solo la siguiente esté en memoria
//            }
//        });

    }
}
