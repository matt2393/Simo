package bo.edu.uto.utoinfo.Presentador.Presenter;

import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import bo.edu.uto.utoinfo.Presentador.Interceptor.LoginInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.LoginView;

public class LoginPresenter implements LoginInterceptor.OnFinishLogin {

    private LoginView loginView;
    private LoginInterceptor loginInterceptor;

    public LoginPresenter(LoginView loginView, LoginInterceptor loginInterceptor) {
        this.loginView = loginView;
        this.loginInterceptor = loginInterceptor;
    }

    public void login(String user,String password){
        loginView.showLoad();
        loginInterceptor.load(user,password, this);
    }

    public void user(String id_persona){
        loginView.showLoad();
        loginInterceptor.user(id_persona,this);
    }

    @Override
    public void loadLogin(Login l) {
        loginView.hideLoad();
        loginView.logueado(l);
    }

    @Override
    public void error(String mensaje) {
        loginView.hideLoad();
        loginView.error(mensaje);
    }

    @Override
    public void loadUser(Usuario us) {
        loginView.hideLoad();
        loginView.loadUser(us);
    }

    /**
     * Api rest
     * GET    recuperar
     * POST    crear, escribir
     * PUT     actualizar
     * DELETE   eleminar
     */
}
