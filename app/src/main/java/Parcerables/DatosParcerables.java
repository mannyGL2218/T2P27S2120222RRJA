package Parcerables;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosParcerables implements Parcelable {
    String nombre;
    int edad;
    String correo;

    public DatosParcerables(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    protected DatosParcerables(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        correo = in.readString();
    }

    public static final Creator<DatosParcerables> CREATOR = new Creator<DatosParcerables>() {
        @Override
        public DatosParcerables createFromParcel(Parcel in) {
            return new DatosParcerables(in);
        }

        @Override
        public DatosParcerables[] newArray(int size) {
            return new DatosParcerables[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(edad);
        parcel.writeString(correo);
    }
}
