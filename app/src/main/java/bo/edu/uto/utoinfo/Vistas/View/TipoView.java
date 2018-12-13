package bo.edu.uto.utoinfo.Vistas.View;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.TiposTram;

public interface TipoView {
    void loadtipo(List<TiposTram> tipos);
    void errorTipo(Throwable e);

    void showLoad();
    void hideLoad();
}
