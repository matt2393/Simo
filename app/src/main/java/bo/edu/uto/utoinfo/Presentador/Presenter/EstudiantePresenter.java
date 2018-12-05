package bo.edu.uto.utoinfo.Presentador.Presenter;

import bo.edu.uto.utoinfo.Modelos.Estudiante;
import bo.edu.uto.utoinfo.Presentador.Interceptor.EstudianteInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.EstudianteView;

public class EstudiantePresenter implements EstudianteInterceptor.OnFinishEst {

    private EstudianteView estudianteView;
    private EstudianteInterceptor estudianteInterceptor;

    public EstudiantePresenter(EstudianteView estudianteView, EstudianteInterceptor estudianteInterceptor) {
        this.estudianteView = estudianteView;
        this.estudianteInterceptor = estudianteInterceptor;
    }

    public void loadEst(String id_e){
        estudianteView.showLoad();
        estudianteInterceptor.loadEst(id_e,this);
    }

    @Override
    public void onFinish(Estudiante es) {
        estudianteView.hideLoad();
        estudianteView.onLoad(es);
    }

    @Override
    public void onError(Throwable e) {
        estudianteView.hideLoad();
        estudianteView.error(e);
    }
}
