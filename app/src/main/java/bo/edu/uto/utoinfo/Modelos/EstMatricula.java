package bo.edu.uto.utoinfo.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class EstMatricula implements Parcelable {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.total);
    }

    public EstMatricula() {
    }

    protected EstMatricula(Parcel in) {
        this.total = in.readString();
    }

    public static final Parcelable.Creator<EstMatricula> CREATOR = new Parcelable.Creator<EstMatricula>() {
        @Override
        public EstMatricula createFromParcel(Parcel source) {
            return new EstMatricula(source);
        }

        @Override
        public EstMatricula[] newArray(int size) {
            return new EstMatricula[size];
        }
    };
}
