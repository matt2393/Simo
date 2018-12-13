package bo.edu.uto.utoinfo.Presentador.Interceptor;

import java.util.List;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.Tramite;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TramiteInterceptor {
    public static abstract class OnFinishTramite{
        protected abstract void onLoadTramite(List<Tramite> tramites);
        protected abstract void onError(Throwable e);
    }
    public void loadTramite(String id_tipo,OnFinishTramite onFinishTramite){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                .tramites(id_tipo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFinishTramite::onLoadTramite,onFinishTramite::onError)
        );
    }
}
