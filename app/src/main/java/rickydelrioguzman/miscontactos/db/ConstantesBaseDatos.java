package rickydelrioguzman.miscontactos.db;
public final class ConstantesBaseDatos {
    // Esta clase contiene constantes que serpan usadas para configurar y manejar la base de datos.
    // Algunas de estas contantes se usan varias veces, por lo que es recomendable manejarlas en
    // este archivo para evitar errores de tipeo.
    
    // De la base de datos:
    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;
    
    // De la tabla de contactos:
    public static final String TABLE_CONTACTS = "contacto";
    public static final String TABLE_CONTACTS_ID = "id";
    public static final String TABLE_CONTACTS_NOMBRE = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO = "telefono";
    public static final String TABLE_CONTACTS_EMAIL = "email";
    public static final String TABLE_CONTACTS_FOTO = "foto";
    
    // De la tabla de likes:
    public static final String TABLE_LIKES_CONTACTS = "contacto_likes";
    public static final String TABLE_LIKES_CONTACTS_ID = "id";
    public static final String TABLE_LIKES_CONTACTS_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_CONTACTS_NUMERO_LIKES = "numero_likes";
}
