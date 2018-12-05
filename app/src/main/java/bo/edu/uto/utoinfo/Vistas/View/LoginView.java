package bo.edu.uto.utoinfo.Vistas.View;

import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Usuario;

public interface LoginView {
    void logueado(Login lo);
    void error(String mess);
    void showLoad();
    void hideLoad();

    void loadUser(Usuario us);
}
