package bo.edu.uto.utoinfo.ApiRequest;

import bo.edu.uto.utoinfo.Modelos.Estudiante;
import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Persona;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Requests {

    @FormUrlEncoded
    @POST("conexion/login")
    public Observable<Login> logear(@Field("user") String user,@Field("pass") String pass);


    @FormUrlEncoded
    @POST("persona/nombre_dip")
    public Observable<Usuario> usuario(@Field("id_p") String id_persona);


    @FormUrlEncoded
    @POST("estudiante")
    public Observable<Estudiante> estudiante(@Field("id_e") String id_estudiante);


    @FormUrlEncoded
    @POST("persona")
    public Observable<Persona> persona(@Field("id_p") String id_persona);


}
