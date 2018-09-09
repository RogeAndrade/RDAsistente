package mx.reddam.rdasistente.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class DataUserModelRequest {
    @SerializedName("Nombre")
    public String nombre;

    @SerializedName("Apellidos")
    public String apellidos;

    @SerializedName("Telefono")
    public String telefono;

    @SerializedName("Correo")
    public String correo;

    @SerializedName("Url")
    public String url;

    @SerializedName("Usr")
    public String usr;

    @SerializedName("Pass")
    public String pass;

    @SerializedName("Facebook")
    public String facebook;

    @SerializedName("Google")
    public String google;

    @SerializedName("Mail")
    public String mail;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
