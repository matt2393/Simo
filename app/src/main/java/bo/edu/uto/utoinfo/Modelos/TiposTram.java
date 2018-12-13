package bo.edu.uto.utoinfo.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class TiposTram implements Parcelable {
    private String id_tipo_usuario;
    private String usuarios;
    private String numero;

    public String getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(String id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_tipo_usuario);
        dest.writeString(this.usuarios);
        dest.writeString(this.numero);
    }

    public TiposTram() {
    }

    protected TiposTram(Parcel in) {
        this.id_tipo_usuario = in.readString();
        this.usuarios = in.readString();
        this.numero = in.readString();
    }

    public static final Parcelable.Creator<TiposTram> CREATOR = new Parcelable.Creator<TiposTram>() {
        @Override
        public TiposTram createFromParcel(Parcel source) {
            return new TiposTram(source);
        }

        @Override
        public TiposTram[] newArray(int size) {
            return new TiposTram[size];
        }
    };
}
