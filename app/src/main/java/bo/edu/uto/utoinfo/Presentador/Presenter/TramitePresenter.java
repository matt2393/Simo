package bo.edu.uto.utoinfo.Presentador.Presenter;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.Tramite;
import bo.edu.uto.utoinfo.Presentador.Interceptor.TramiteInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.TramiteView;

public class TramitePresenter extends TramiteInterceptor.OnFinishTramite {
    private TramiteView tramiteView;
    private TramiteInterceptor tramiteInterceptor;

    public TramitePresenter(TramiteView tramiteView, TramiteInterceptor tramiteInterceptor) {
        this.tramiteView = tramiteView;
        this.tramiteInterceptor = tramiteInterceptor;
    }

    public void loadTramite(String id_tipo){
        tramiteView.showLoad();
        tramiteInterceptor.loadTramite(id_tipo,this);
    }

    @Override
    protected void onLoadTramite(List<Tramite> tramites) {
        tramiteView.hideLoad();
        tramiteView.loadTramite(tramites);
    }

    @Override
    protected void onError(Throwable e) {
        tramiteView.hideLoad();
        tramiteView.errorTramite(e);
    }
}
