package bo.edu.uto.utoinfo.Presentador.Presenter;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.TiposTram;
import bo.edu.uto.utoinfo.Presentador.Interceptor.TipoInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.TipoView;

public class TipoPresenter extends TipoInterceptor.OnFinishTipo {
    private TipoView tipoView;
    private TipoInterceptor tipoInterceptor;

    public TipoPresenter(TipoView tipoView, TipoInterceptor tipoInterceptor) {
        this.tipoView = tipoView;
        this.tipoInterceptor = tipoInterceptor;
    }

    public void loadTipo(){
        tipoView.showLoad();
        tipoInterceptor.loadTipos(this);
    }

    @Override
    protected void onLoadTipo(List<TiposTram> t) {
        tipoView.hideLoad();
        tipoView.loadtipo(t);
    }

    @Override
    protected void onError(Throwable e) {
        tipoView.hideLoad();
        tipoView.errorTipo(e);
    }
}
