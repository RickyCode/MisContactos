package rickydelrioguzman.miscontactos.view_fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rickydelrioguzman.miscontactos.R;
import rickydelrioguzman.miscontactos.adapter.ContactoAdaptador;
import rickydelrioguzman.miscontactos.pojo.Contacto;
import rickydelrioguzman.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import rickydelrioguzman.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    // Esta clase es la encargada de generar y configurar la vista del "RecyclerView" y el
    // "Fragment" o "Layout" en el que se encontrará dicho "RecyclerView"
    // Esta clase es utilizada en el presetnador
    
    
    
    // Declaraciones:
    private RecyclerView listaContactos;
    static public ArrayList<Contacto> contactos;
    private IRecyclerViewFragmentPresenter presenter;
    
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Asociación del código java con el formato XML
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false); // Equivale al "setContentView"  de una activity
        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext()); // Esto es lo que reemplaza "inicializarcontactos()"
//        inicializarListaContactos();
        return v;
    }
    
    
    
    @Override
    public void generarLinearLayoutVertical() {
        // Forma en que se muestra el "RecyclerView":
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
//        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
//        listaContactos.setLayoutManager(glm);
    }
    
    
    
    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        
        return adaptador;
    }
    
    
    
    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
