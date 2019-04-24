package rickydelrioguzman.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.TextView;
import android.view.View;
import 	android.net.Uri;

import rickydelrioguzman.miscontactos.R;

import rickydelrioguzman.miscontactos.view_fragments.RecyclerViewFragment;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    private Bundle parametros;
    private String nombre;
    private String telefono;
    private String email;
    private int    posicion;


    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString(); //".getText()" retorna un objeto "CharSecuense"

        // Revisión de que el usuario haya dado permiso de usar las llamdas:
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono))); //Intent implícito
        
    }

    public void enviarEmail(View v) {
        String email       = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
//        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "hola hola");
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Cuando se presiona el botón para volver a atrás se vuelve a abrir "MainActivity"
        // Que está configurada para cerrarse para ahorar espacio en memoria
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        posicion = getIntent().getExtras().getInt("POSICION");
        nombre       = RecyclerViewFragment.contactos.get(posicion).getNombre();
        telefono     = RecyclerViewFragment.contactos.get(posicion).getTelefono();
        email        = RecyclerViewFragment.contactos.get(posicion).getEmail();

//        parametros   = getIntent().getExtras();
//        nombre       = parametros.getString(getResources().getString(R.string.pnombre));
//        telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
//        email        = parametros.getString(getResources().getString(R.string.pemail));

        tvNombre     = (TextView) findViewById(R.id.tvNombre);
        tvTelefono   = (TextView) findViewById(R.id.tvTeléfono);
        tvEmail      = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);

    }
}
