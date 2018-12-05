package bo.edu.uto.utoinfo.Vistas.View;

import bo.edu.uto.utoinfo.Modelos.Estudiante;

public interface EstudianteView {
    void onLoad(Estudiante es);
    void showLoad();
    void hideLoad();
    void error(Throwable e);
}
