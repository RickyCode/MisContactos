package rickydelrioguzman.miscontactos.db;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import rickydelrioguzman.miscontactos.pojo.Contacto;

import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.DATABASE_NAME;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.DATABASE_VERSION;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_EMAIL;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_FOTO;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_ID;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_LIKES_CONTACTS;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO;
import static rickydelrioguzman.miscontactos.db.ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKES;

public class BaseDatos extends SQLiteOpenHelper {
    // Esta clase ayuda a crear y manejar la base de datos
    // En las funciones OnCreate y OnUpgrade reciben un objeto "SQLiteDataBase"
    
    private Context context;
    
    
    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    
    
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Lo que se crea es la estructura de la base de datos.
        // La base de datos se crea al instanciar esta clase.
        // Si la base de datos existe, la abre, si no existe, la crea.
        
        // En lenguaje SQL:
        // Se diseña la tabla de los contactos:
        String queryCrearTablaContacto = "CREATE TABLE " +
                TABLE_CONTACTS          + "(" +
                TABLE_CONTACTS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_CONTACTS_NOMBRE   + " TEXT, " +
                TABLE_CONTACTS_TELEFONO + " TEXT, " +
                TABLE_CONTACTS_EMAIL    + " TEXT, " +
                TABLE_CONTACTS_FOTO     + " INTEGER " +
                ")";
        
        // Se diseña la tabla de los "likes":
        String queryrearTablaLikesContacto = "CREATE TABLE " +
                TABLE_LIKES_CONTACTS               + "(" +
                TABLE_LIKES_CONTACTS_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_LIKES_CONTACTS_ID_CONTACTO   + " INTEGER, " +
                TABLE_LIKES_CONTACTS_NUMERO_LIKES  + " INTEGER, " +
                "FOREIGN KEY (" + TABLE_LIKES_CONTACTS_ID_CONTACTO + ") "+
                "REFERENCES " + TABLE_CONTACTS + "(" + TABLE_CONTACTS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaContacto); // Se crea la tabla de contactos
        db.execSQL(queryrearTablaLikesContacto); // Se crea la tabña de likes
    }
    
    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Modifica la estructura de la base de datos
        // Cuando hemos creado otra estructura debemos ejecutarlo.
        // Elimina las tablas existentes y crea las crea de nuevo con la nueva estructura:
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS_ID);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIKES_CONTACTS);
        onCreate(db);
    }
    
    
    
    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();
        String query = "SELECT * FROM " +  TABLE_CONTACTS;
        
        SQLiteDatabase db = this.getWritableDatabase();
        // Se crea un objeto "Cursor":
        Cursor registros = db.rawQuery(query, null); // null pq no estamos aplicando ningún filtro
        // Recorremos los registros y llenamos el "ArrayList"
        while (registros.moveToNext()) {
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));
            contactoActual.setLikes(obtenerLikesContacto(contactoActual));
            
            contactos.add(contactoActual);
//            contactoActual.setLikes();
        }
        db.close();
        return contactos;
    }
    
    
    
    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_CONTACTS, null, contentValues); // Se entregan los datos como diccionarios
        db.close();
    }
    
    
    
    public void insertarLikeContacto(ContentValues contentValues){
        // Este método recibe un "ContentValues" que es como un diccionario con los datos que
        // serán cargados a la tabla de la base de datos.
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LIKES_CONTACTS, null, contentValues);
        db.close();
    }
    
    
    
    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;
        String query = "SELECT COUNT(" + TABLE_LIKES_CONTACTS_NUMERO_LIKES + // COUNT hace la suma de los valores de un campo
                ") FROM " + TABLE_LIKES_CONTACTS +
                " WHERE " + TABLE_LIKES_CONTACTS_ID_CONTACTO + "=" + contacto.getId();
        
        SQLiteDatabase db = getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        
        if (registros.moveToNext()){ // Usamos un if en vez de un while pq solo tenemos una columna.
            likes = registros.getInt(0); // Solo hay una columna por lo que su índice es cero
        }
        db.close();
        
        
        return likes;
    }
}
