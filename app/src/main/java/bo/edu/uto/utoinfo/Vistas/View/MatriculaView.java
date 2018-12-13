package bo.edu.uto.utoinfo.Vistas.View;

import bo.edu.uto.utoinfo.Modelos.EstMatricula;
import bo.edu.uto.utoinfo.Modelos.Matricula;

public interface MatriculaView {
    void onLoadMatricula(Matricula m);
    void onLoadEstMatricula(EstMatricula est_m);
    void onErrorMatricula(Throwable e);
    void onErrorEstMat(Throwable e);
    void showLoad();
    void hideLoad();
}
