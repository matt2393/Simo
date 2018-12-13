package bo.edu.uto.utoinfo.Presentador.Interceptor;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.EstMatricula;
import bo.edu.uto.utoinfo.Modelos.Matricula;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MatriculaInterceptor {

    public static abstract class OnFinishMatricula{
        protected abstract void onLoadMatricula(Matricula mt);
        protected abstract void onLoadEstMat(EstMatricula estMat);

        protected abstract void onErrorMat(Throwable e);
        protected abstract void onErrorEstMat(Throwable e);
    }

    public void loadMat(String id_p,String id_e, OnFinishMatricula onFinishMatricula){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                .matricula(id_p,id_e)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFinishMatricula::onLoadMatricula,onFinishMatricula::onErrorMat)
        );
    }

    public void loadEstMat(String id_p,String id_e, OnFinishMatricula onFinishMatricula){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                        .est_matricula(id_p,id_e)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(onFinishMatricula::onLoadEstMat,onFinishMatricula::onErrorEstMat)
        );
    }
}
