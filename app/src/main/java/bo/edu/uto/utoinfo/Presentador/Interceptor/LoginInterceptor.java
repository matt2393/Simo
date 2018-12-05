package bo.edu.uto.utoinfo.Presentador.Interceptor;

import android.text.TextUtils;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginInterceptor {

    public interface OnFinishLogin {
        void loadLogin(Login l);

        void error(String mensaje);

        void loadUser(Usuario us);
    }

    public void load(String user, String password, OnFinishLogin onFinishLogin) {
        if (TextUtils.isEmpty(user)) {
            onFinishLogin.error("Escriba un nombre usuario");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            onFinishLogin.error("Escriba su contraseña");
            return;
        }

      /*  if(user.equals("matt") && password.equals("12345")){
            onFinishLogin.loadLogin();
        }
        else
            onFinishLogin.error("Error en los datos");
            */

        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                        .logear(user, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(res -> {
                            if (res.isLogueado())
                                onFinishLogin.loadLogin(res);
                            else {
                                onFinishLogin.error("No se autentico");
                            }
                        }, error -> {
                            onFinishLogin.error(error.getMessage());
                        })
        );
    }

    public void user(String id_persona, OnFinishLogin onFinishLogin) {
        if (TextUtils.isEmpty(id_persona) || id_persona.equals("-1")) {
            onFinishLogin.error("Intenten nuevamente");
            return;
        }

        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                        .usuario(id_persona)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(onFinishLogin::loadUser,
                                error -> {
                                    onFinishLogin.error(error.getMessage());
                                })
        );
    }
}
