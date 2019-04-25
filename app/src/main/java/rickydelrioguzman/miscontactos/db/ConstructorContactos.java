package rickydelrioguzman.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import rickydelrioguzman.miscontactos.R;
import rickydelrioguzman.miscontactos.pojo.Contacto;

import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_EMAIL;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_FOTO;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKES;

public class ConstructorContactos {
    private static final int LIKE = 1;
    // Esta clase ayudará a construir los contactos necesarios.
    // El "Interactor"
    // Consulta la base de datos.
    // Esta es la clase calve para estar cambiando la fuente de los datos (base de datos/ web service)
    // Se deben definir algunos estándares, sin importar de dónde vengan los datos.
    private Context context;
    private BaseDatos db;
    
    
    
    // Constructor:
    public ConstructorContactos(Context context) {
        this.context = context;
        this.db = new BaseDatos(context);
        insertarSieteContactos(db);
    }
    
    
    
    public ArrayList<Contacto> obtenerDatos(){
        //MOVIDO AL CONSTRUCTOR: BaseDatos db = new BaseDatos(context);
        // MOVIDO AL CONSTRUCTOR: insertarSieteContactos(db);
        return db.obtenerTodosLosContactos();
    }
    
    
    
    public void insertarSieteContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Anahí Salgado");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.blank_profile);
        
        db.insertarContacto(contentValues);
    
        contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Ricardo Del Río");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.blank_profile);
    
        db.insertarContacto(contentValues);
    
        contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Pedro Sánchez");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.shadow);
    
        db.insertarContacto(contentValues);
    
        contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Mireya Martinez");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.eyes);
    
        db.insertarContacto(contentValues);
    
        contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Juan Lopez");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.violet_blue);
    
        db.insertarContacto(contentValues);
    
        contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Anita Morales");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.blank_profile);
    
        db.insertarContacto(contentValues);
        
        contentValues = new ContentValues();
        contentValues.put(TABLE_CONTACTS_NOMBRE, "Javiera Soto");
        contentValues.put(TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(TABLE_CONTACTS_EMAIL, "hola@gmail.com");
        contentValues.put(TABLE_CONTACTS_FOTO, R.drawable.cat);
    
        db.insertarContacto(contentValues);
    }
    
    
    
    public void darLikeContacto(Contacto contacto){
        // Se abre la base de datos:
        BaseDatos db = new BaseDatos(context);
        // Se crea el "ContenValues":
        ContentValues contentValues = new ContentValues();
        // Se rellena el "ContentValues":
        contentValues.put(TABLE_LIKES_CONTACTS_ID_CONTACTO, contacto.getId());
        contentValues.put(TABLE_LIKES_CONTACTS_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }
    
    
    
    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}




// LO  QUE EN UNA PRIMERA ETAPA ESTABA EN EL MÉTODO "obtenerDatos()":

//        // Estándar: Los datos deben venir en un "ArrayList"
//        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
//        // Población de la lista (Dummy) :
//        contactos.add(new Contacto(R.drawable.blank_profile, "Ricardo Del Río", "77779999", "ricky@mail.com", 0));
//        contactos.add(new Contacto(R.drawable.shadow ,"Pedro Sanchez", "88882222", "algo@otroalgo.com", 0));
//        contactos.add(new Contacto(R.drawable.eyes ,"Mireya Martinez", "33331111", "algo@otroalgo.com", 0));
//        contactos.add(new Contacto(R.drawable.violet_blue ,"Juan Lopez", "44442222", "algo@otroalgo.com", 0));
//        contactos.add(new Contacto(R.drawable.blank_profile ,"Anita Morales", "12341234", "algo@otroalgo.com", 0));
//        contactos.add(new Contacto(R.drawable.cat ,"Javiera Soto", "56785678", "algo@otroalgo.com", 0));
//        return contactos;