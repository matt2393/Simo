package bo.edu.uto.utoinfo.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private String paterno,materno,nombres;
    private String ap_casada,pais,departamento;
    private String provincia,localidad,fec_nacimiento;
    private String direccion,telefono,celular;
    private String correo,dpto,distrito,colegio;
    private String tipo_documento,dip,tipo_exp;
    private String tipo_sexo,tipo_estado_civil;
    private String anio_bachiller,tipo_sangre,dependencia;


    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_casada() {
        return ap_casada;
    }

    public void setAp_casada(String ap_casada) {
        this.ap_casada = ap_casada;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFec_nacimiento() {
        return fec_nacimiento;
    }

    public void setFec_nacimiento(String fec_nacimiento) {
        this.fec_nacimiento = fec_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public String getTipo_exp() {
        return tipo_exp;
    }

    public void setTipo_exp(String tipo_exp) {
        this.tipo_exp = tipo_exp;
    }

    public String getTipo_sexo() {
        return tipo_sexo;
    }

    public void setTipo_sexo(String tipo_sexo) {
        this.tipo_sexo = tipo_sexo;
    }

    public String getTipo_estado_civil() {
        return tipo_estado_civil;
    }

    public void setTipo_estado_civil(String tipo_estado_civil) {
        this.tipo_estado_civil = tipo_estado_civil;
    }

    public String getAnio_bachiller() {
        return anio_bachiller;
    }

    public void setAnio_bachiller(String anio_bachiller) {
        this.anio_bachiller = anio_bachiller;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.paterno);
        dest.writeString(this.materno);
        dest.writeString(this.nombres);
        dest.writeString(this.ap_casada);
        dest.writeString(this.pais);
        dest.writeString(this.departamento);
        dest.writeString(this.provincia);
        dest.writeString(this.localidad);
        dest.writeString(this.fec_nacimiento);
        dest.writeString(this.direccion);
        dest.writeString(this.telefono);
        dest.writeString(this.celular);
        dest.writeString(this.correo);
        dest.writeString(this.dpto);
        dest.writeString(this.distrito);
        dest.writeString(this.colegio);
        dest.writeString(this.tipo_documento);
        dest.writeString(this.dip);
        dest.writeString(this.tipo_exp);
        dest.writeString(this.tipo_sexo);
        dest.writeString(this.tipo_estado_civil);
        dest.writeString(this.anio_bachiller);
        dest.writeString(this.tipo_sangre);
        dest.writeString(this.dependencia);
    }

    public Persona() {
    }

    protected Persona(Parcel in) {
        this.paterno = in.readString();
        this.materno = in.readString();
        this.nombres = in.readString();
        this.ap_casada = in.readString();
        this.pais = in.readString();
        this.departamento = in.readString();
        this.provincia = in.readString();
        this.localidad = in.readString();
        this.fec_nacimiento = in.readString();
        this.direccion = in.readString();
        this.telefono = in.readString();
        this.celular = in.readString();
        this.correo = in.readString();
        this.dpto = in.readString();
        this.distrito = in.readString();
        this.colegio = in.readString();
        this.tipo_documento = in.readString();
        this.dip = in.readString();
        this.tipo_exp = in.readString();
        this.tipo_sexo = in.readString();
        this.tipo_estado_civil = in.readString();
        this.anio_bachiller = in.readString();
        this.tipo_sangre = in.readString();
        this.dependencia = in.readString();
    }

    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel source) {
            return new Persona(source);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}
