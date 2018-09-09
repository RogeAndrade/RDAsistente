package mx.reddam.rdasistente.Persistecia.Modelos;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class DatosUsuarioModelo extends RealmObject{

    @SerializedName("id")
    public int id;

    @SerializedName("nombre")
    public String nombre;

    @SerializedName("apellidos")
    public String apellidos;

    @SerializedName("telefono")
    public String telefono;

    @SerializedName("correo")
    public String correo;

    @SerializedName("url")
    public String url;

    @SerializedName("usr")
    public String usr;

    @SerializedName("facebook")
    public String facebook;

    @SerializedName("google")
    public String google;

    @SerializedName("mail")
    public String mail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
