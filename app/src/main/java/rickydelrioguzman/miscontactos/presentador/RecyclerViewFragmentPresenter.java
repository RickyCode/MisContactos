package rickydelrioguzman.miscontactos.presentador;

import android.content.Context;

import java.util.ArrayList;

import rickydelrioguzman.miscontactos.db.ConstructorContactos;
import rickydelrioguzman.miscontactos.pojo.Contacto;
import rickydelrioguzman.miscontactos.view_fragments.IRecyclerViewFragmentView;
import rickydelrioguzman.miscontactos.view_fragments.RecyclerViewFragment;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    public static ArrayList<Contacto> contactos;
    
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }
    
    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos(); // Nos devuelve un "ArrayList"
        mostrarContactosRV();
    }
    
    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
