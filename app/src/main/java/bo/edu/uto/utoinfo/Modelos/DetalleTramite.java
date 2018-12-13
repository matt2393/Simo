package bo.edu.uto.utoinfo.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class DetalleTramite implements Parcelable {
    private String sub_tramite;
    private String descripcion;
    private String nombre;
    private String referencia;

    public String getSub_tramite() {
        return sub_tramite;
    }

    public void setSub_tramite(String sub_tramite) {
        this.sub_tramite = sub_tramite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sub_tramite);
        dest.writeString(this.descripcion);
        dest.writeString(this.nombre);
        dest.writeString(this.referencia);
    }

    public DetalleTramite() {
    }

    protected DetalleTramite(Parcel in) {
        this.sub_tramite = in.readString();
        this.descripcion = in.readString();
        this.nombre = in.readString();
        this.referencia = in.readString();
    }

    public static final Parcelable.Creator<DetalleTramite> CREATOR = new Parcelable.Creator<DetalleTramite>() {
        @Override
        public DetalleTramite createFromParcel(Parcel source) {
            return new DetalleTramite(source);
        }

        @Override
        public DetalleTramite[] newArray(int size) {
            return new DetalleTramite[size];
        }
    };
}
