package bo.edu.uto.utoinfo.ApiRequest;

import java.util.List;

import bo.edu.uto.utoinfo.Modelos.DetalleTramite;
import bo.edu.uto.utoinfo.Modelos.EstMatricula;
import bo.edu.uto.utoinfo.Modelos.Estudiante;
import bo.edu.uto.utoinfo.Modelos.Login;
import bo.edu.uto.utoinfo.Modelos.Matricula;
import bo.edu.uto.utoinfo.Modelos.Persona;
import bo.edu.uto.utoinfo.Modelos.TiposTram;
import bo.edu.uto.utoinfo.Modelos.Tramite;
import bo.edu.uto.utoinfo.Modelos.Usuario;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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



    @FormUrlEncoded
    @POST("pago_matricula")
    public Observable<Matricula> matricula(@Field("id_p") String id_persona, @Field("id_e") String id_est);

    @FormUrlEncoded
    @POST("pago_matricula/monto_matricula")
    public Observable<EstMatricula> est_matricula(@Field("id_p") String id_persona, @Field("id_e") String id_est);


    @GET("informaciones/tipos")
    public Observable<List<TiposTram>> tipo_tramite();

    @GET("informaciones/tramites/{tipo}")
    public Observable<List<Tramite>> tramites(@Path("tipo") String tipo);

    @GET("informaciones/detalles/{tram}")
    public Observable<List<DetalleTramite>> detalle_tramite(@Path("tram") String id_tramite);
}
