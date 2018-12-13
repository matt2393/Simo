package bo.edu.uto.utoinfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import bo.edu.uto.utoinfo.Tools.Const;
import bo.edu.uto.utoinfo.Vistas.Fragments.FragmentInicio;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        Login login=new Login();
        Usuario us=new Usuario();
        login.setX(preferences.getInt(Const.ID_P,0));
        login.setY(preferences.getInt(Const.ID_E,0));
        us.setDip(preferences.getString(Const.DIP,null));
        us.setNombre(preferences.getString(Const.NOM,null));

        if(login.getX()!=0 && login.getY()!=0 && us.getDip()!=null && us.getNombre()!=null){
            Intent in=new Intent(this,MainActivity.class);
            in.putExtra(Const.USUARIO,us);
            in.putExtra(Const.LOGIN,login);
            startActivity(in);
            finish();
        }
        else {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor_login, new FragmentInicio()).commit();
        }
    }
}
