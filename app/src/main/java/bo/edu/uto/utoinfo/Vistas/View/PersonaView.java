package bo.edu.uto.utoinfo.Vistas.View;

import bo.edu.uto.utoinfo.Modelos.Persona;

public interface PersonaView {

    void onLoadPersona(Persona p);
    void onError(Throwable e);

    void showLoad();
    void hideLoad();
}
