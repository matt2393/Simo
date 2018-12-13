package bo.edu.uto.utoinfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import bo.edu.uto.utoinfo.Tools.Const;
import bo.edu.uto.utoinfo.Tools.GlideApp;
import bo.edu.uto.utoinfo.Vistas.Dialogs.DialogImagen;
import bo.edu.uto.utoinfo.Vistas.Fragments.FragmetOpciones;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen_estudiante;
    private TextView nombre_estudiante,logout;
    private Usuario us;
    private Login login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen_estudiante=findViewById(R.id.imagen_estudiante);
        nombre_estudiante=findViewById(R.id.nombre_estudiante);
        logout=findViewById(R.id.logout);

        if(getIntent()!=null){
            us=getIntent().getParcelableExtra(Const.USUARIO);
            login=getIntent().getParcelableExtra(Const.LOGIN);

            nombre_estudiante.setText(us.getNombre());

            final String url=Const.URL_IMAGEN+us.getDip()+".jpg";
            GlideApp.with(this)
                    .load(url)
                    .into(imagen_estudiante);


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor_main,FragmetOpciones.newInstence(
                            String.valueOf(login.getY()),String.valueOf(login.getX())
                    ))
                    .commit();

            imagen_estudiante.setOnClickListener(v -> {
                DialogImagen.newInstance(url)
                        .show(getSupportFragmentManager(),DialogImagen.TAG);
            });
        }

        logout.setOnClickListener(v -> {
            SharedPreferences preferences=PreferenceManager
                    .getDefaultSharedPreferences(this.getApplicationContext());

            preferences.edit().remove(Const.ID_E)
                    .remove(Const.ID_P)
                    .remove(Const.DIP)
                    .remove(Const.NOM)
                    .apply();
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });


    }
}
