package bo.edu.uto.utoinfo.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Tramite implements Parcelable {
    private String id_tramite;
    private String tramite;

    public String getId_tramite() {
        return id_tramite;
    }

    public void setId_tramite(String id_tramite) {
        this.id_tramite = id_tramite;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_tramite);
        dest.writeString(this.tramite);
    }

    public Tramite() {
    }

    protected Tramite(Parcel in) {
        this.id_tramite = in.readString();
        this.tramite = in.readString();
    }

    public static final Parcelable.Creator<Tramite> CREATOR = new Parcelable.Creator<Tramite>() {
        @Override
        public Tramite createFromParcel(Parcel source) {
            return new Tramite(source);
        }

        @Override
        public Tramite[] newArray(int size) {
            return new Tramite[size];
        }
    };
}
