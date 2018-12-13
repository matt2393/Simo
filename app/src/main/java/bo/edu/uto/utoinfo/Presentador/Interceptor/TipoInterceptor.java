package bo.edu.uto.utoinfo.Presentador.Interceptor;

import java.util.List;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.TiposTram;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TipoInterceptor {

    public static abstract class OnFinishTipo{
        protected abstract void onLoadTipo(List<TiposTram> t);
        protected abstract void onError(Throwable e);
    }

    public void loadTipos(OnFinishTipo onFinishTipo){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                .tipo_tramite()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFinishTipo::onLoadTipo,onFinishTipo::onError)
        );
    }
}
