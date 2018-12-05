package bo.edu.uto.utoinfo.Vistas.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import bo.edu.uto.utoinfo.MainActivity;
import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import bo.edu.uto.utoinfo.Presentador.Interceptor.LoginInterceptor;
import bo.edu.uto.utoinfo.Presentador.Presenter.LoginPresenter;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Tools.Const;
import bo.edu.uto.utoinfo.Vistas.Dialogs.DialogLoad;
import bo.edu.uto.utoinfo.Vistas.View.LoginView;

public class FragmentLogin extends Fragment implements View.OnClickListener,
        LoginView {


    private TextInputEditText user,pass;
    private Button loguear,invitado;
    private LoginPresenter loginPresenter;
    private Login login;
    private DialogLoad dialogLoad;

    public static FragmentLogin newInstance(){
        FragmentLogin fr=new FragmentLogin();
        return fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login,container,false);

        user=view.findViewById(R.id.usuario);
        pass=view.findViewById(R.id.password);
        loguear=view.findViewById(R.id.loguear);
        invitado=view.findViewById(R.id.invitado);

        dialogLoad=DialogLoad.newInstance();


        loguear.setOnClickListener(this);
        invitado.setOnClickListener(this);

        loginPresenter=new LoginPresenter(this,new LoginInterceptor());

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loguear:
                if(loginPresenter!=null){
                    loginPresenter.login(user.getText().toString(),pass.getText().toString());
                }
                break;
            case R.id.invitado: break;
        }
    }

    @Override
    public void logueado(Login lo) {
        if(loginPresenter!=null){
            this.login=lo;
            loginPresenter.user(String.valueOf(lo.getX()));
        }
    }

    @Override
    public void error(String mess) {
        Toast.makeText(getContext(),mess,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoad() {
        if(dialogLoad!=null)
            dialogLoad.show(getActivity().getSupportFragmentManager(),DialogLoad.TAG);
    }

    @Override
    public void hideLoad() {
        if(dialogLoad!=null)
            dialogLoad.dismiss();
    }

    @Override
    public void loadUser(Usuario us) {
        Intent in=new Intent(getContext(),MainActivity.class);
        in.putExtra(Const.USUARIO,us);
        in.putExtra(Const.LOGIN,login);
        startActivity(in);
    }
}
