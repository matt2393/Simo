package bo.edu.uto.utoinfo.Presentador.Interceptor;

import bo.edu.uto.utoinfo.ApiRequest.RetrofitSingleton;
import bo.edu.uto.utoinfo.Modelos.Persona;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PersonaInterceptor {

    public static abstract class OnFinishPersona{
        public OnFinishPersona() {
        }

        protected abstract void onLoad(Persona p);
        protected abstract void onError(Throwable e);
    }

    public void load(String id_p,OnFinishPersona onFinishPersona){
        RetrofitSingleton.getInstance().addReq(
                RetrofitSingleton.getInstance().getRequests()
                .persona(id_p)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFinishPersona::onLoad,onFinishPersona::onError)
        );
    }
}
