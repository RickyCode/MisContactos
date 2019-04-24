package rickydelrioguzman.miscontactos.view_fragments;

import java.util.ArrayList;

import rickydelrioguzman.miscontactos.adapter.ContactoAdaptador;
import rickydelrioguzman.miscontactos.pojo.Contacto;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
