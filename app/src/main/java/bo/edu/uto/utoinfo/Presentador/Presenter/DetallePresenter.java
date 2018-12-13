package bo.edu.uto.utoinfo.Presentador.Presenter;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.DetalleTramite;
import bo.edu.uto.utoinfo.Presentador.Interceptor.DetalleInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.DetalleView;

public class DetallePresenter extends DetalleInterceptor.OnFinishDetalle {

    private DetalleView detalleView;
    private DetalleInterceptor detalleInterceptor;

    public DetallePresenter(DetalleView detalleView, DetalleInterceptor detalleInterceptor) {
        this.detalleView = detalleView;
        this.detalleInterceptor = detalleInterceptor;
    }

    public void loadDetalle(String id_tram){
        detalleView.showLoad();
        detalleInterceptor.loadDetalle(id_tram,this);
    }

    @Override
    protected void onLoadDetalle(List<DetalleTramite> detalles) {
        detalleView.hideLoad();
        detalleView.loadDetalle(detalles);
    }

    @Override
    protected void onError(Throwable e) {
        detalleView.hideLoad();
        detalleView.errorDetalle(e);
    }
}
