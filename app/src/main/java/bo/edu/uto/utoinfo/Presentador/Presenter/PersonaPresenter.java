package bo.edu.uto.utoinfo.Presentador.Presenter;

import bo.edu.uto.utoinfo.Modelos.Persona;
import bo.edu.uto.utoinfo.Presentador.Interceptor.PersonaInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.PersonaView;

public class PersonaPresenter extends PersonaInterceptor.OnFinishPersona {

    private PersonaView personaView;
    private PersonaInterceptor personaInterceptor;

    public PersonaPresenter(PersonaView personaView, PersonaInterceptor personaInterceptor) {
        this.personaView = personaView;
        this.personaInterceptor = personaInterceptor;
    }

    public void load(String id_p){
        personaView.showLoad();
        personaInterceptor.load(id_p,this);
    }

    @Override
    protected void onLoad(Persona p) {
        personaView.hideLoad();
        personaView.onLoadPersona(p);
    }

    @Override
    protected void onError(Throwable e) {
        personaView.hideLoad();
        personaView.onError(e);
    }
}
