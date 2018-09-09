package mx.reddam.rdasistente.Servicios;

import mx.reddam.rdasistente.Models.DataUserModelRequest;
import mx.reddam.rdasistente.Models.SignUserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public interface IServices {
    @PUT("User")
    Call<SignUserResponse> signUser(@Body DataUserModelRequest datos);
}
