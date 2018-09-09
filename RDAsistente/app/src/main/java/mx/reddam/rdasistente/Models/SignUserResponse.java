package mx.reddam.rdasistente.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class SignUserResponse extends ResponseModel {
    @SerializedName("idUser")
    public int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
