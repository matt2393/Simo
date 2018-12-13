package bo.edu.uto.utoinfo.Vistas.View;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.DetalleTramite;

public interface DetalleView {
    void loadDetalle(List<DetalleTramite> detalles);
    void errorDetalle(Throwable e);

    void showLoad();
    void hideLoad();
}
