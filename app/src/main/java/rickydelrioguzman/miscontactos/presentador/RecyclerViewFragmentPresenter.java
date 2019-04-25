package rickydelrioguzman.miscontactos.presentador;

import android.content.Context;

import java.util.ArrayList;

import rickydelrioguzman.miscontactos.db.ConstructorContactos;
import rickydelrioguzman.miscontactos.pojo.Contacto;
import rickydelrioguzman.miscontactos.view_fragments.IRecyclerViewFragmentView;
import rickydelrioguzman.miscontactos.view_fragments.RecyclerViewFragment;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    // Esta clase se encarga de prepara la información que se mostrará en la vista.
    // Recibe los datos de "ConstructorContactos" (que a su vez los recibe de una BD o de un
    // "WebService"), entrega el listado de contactos al adaptador del "RecyclerView"  y genera
    // y configura dicho "ReciclerView"
    // Para estas configuraciones utiliza la clase RecyclerViewFragment
    
    // Declaraciones:
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    public static ArrayList<Contacto> contactos;
    
    
    
    // Constructor:
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
        mostrarContactosRV();
    }
    
    
    
    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos(); // Nos devuelve un "ArrayList"
    }
    
    
    
    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
