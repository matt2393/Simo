package bo.edu.uto.utoinfo.Presentador.Interceptor;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.Estudiante;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EstudianteInterceptor {

    public interface OnFinishEst{
        void onFinish(Estudiante es);
        void onError(Throwable e);
    }

    public void loadEst(String id_e, OnFinishEst onFinishEst){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                .estudiante(id_e)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFinishEst::onFinish,onFinishEst::onError)
        );
    }
}
