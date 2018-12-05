package bo.edu.uto.utoinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bo.edu.uto.utoinfo.Vistas.Fragments.FragmentInicio;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor_login,new FragmentInicio()).commit();
    }
}
