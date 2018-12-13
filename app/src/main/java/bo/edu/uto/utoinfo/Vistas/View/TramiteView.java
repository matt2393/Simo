package bo.edu.uto.utoinfo.Vistas.View;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.Tramite;

public interface TramiteView {
    void loadTramite(List<Tramite> tramites);
    void errorTramite(Throwable e);

    void showLoad();
    void hideLoad();
}
