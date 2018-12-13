package bo.edu.uto.utoinfo.Presentador.Interceptor;

import java.util.List;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.DetalleTramite;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetalleInterceptor {

    public static abstract class OnFinishDetalle{
        protected abstract void onLoadDetalle(List<DetalleTramite> detalles);
        protected abstract void onError(Throwable e);
    }
    public void loadDetalle(String id_tram, OnFinishDetalle onFinishDetalle){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                .detalle_tramite(id_tram)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFinishDetalle::onLoadDetalle,onFinishDetalle::onError)
        );
    }
}
