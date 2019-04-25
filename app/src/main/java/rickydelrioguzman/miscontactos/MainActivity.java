package rickydelrioguzman.miscontactos;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;


import rickydelrioguzman.miscontactos.R;

import rickydelrioguzman.miscontactos.adapter.PageAdapter;
import rickydelrioguzman.miscontactos.view_fragments.PerfilFragment;
import rickydelrioguzman.miscontactos.view_fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    
    
    // Declaración de "Views" utilizadas:
    // Aquí sólo van las "Views" sobre las que se realiza alguna acción
    ListView lstContactos;
    // Declaración de variables:
    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    
    
    
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        
        return fragments;
    }
    
    
    
    private void setUpViewPager(){
        // Pone en orbita los fragments
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }

    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toolBar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        
        if (toolBar != null){
            setSupportActionBar(toolBar);
        }
    }
}



// ESTO SE USABA ANTES DE LAS BASES DE DATOS:

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
