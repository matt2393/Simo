package bo.edu.uto.utoinfo.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Matricula implements Parcelable {
    private String esta_pagado,monto;
    private String id_estado;

    public String getEsta_pagado() {
        return esta_pagado;
    }

    public void setEsta_pagado(String esta_pagado) {
        this.esta_pagado = esta_pagado;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.esta_pagado);
        dest.writeString(this.monto);
        dest.writeString(this.id_estado);
    }

    public Matricula() {
    }

    protected Matricula(Parcel in) {
        this.esta_pagado = in.readString();
        this.monto = in.readString();
        this.id_estado = in.readString();
    }

    public static final Parcelable.Creator<Matricula> CREATOR = new Parcelable.Creator<Matricula>() {
        @Override
        public Matricula createFromParcel(Parcel source) {
            return new Matricula(source);
        }

        @Override
        public Matricula[] newArray(int size) {
            return new Matricula[size];
        }
    };
}
