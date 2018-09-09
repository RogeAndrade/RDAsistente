package mx.reddam.rdasistente.Negocio.Controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import mx.reddam.rdasistente.Enums.EnumTipoRespuesta;
import mx.reddam.rdasistente.Helpers.AlertsHelper;
import mx.reddam.rdasistente.Interfaces.ISignUser;
import mx.reddam.rdasistente.Models.DataUserModelRequest;
import mx.reddam.rdasistente.Models.SignUserResponse;
import mx.reddam.rdasistente.R;
import mx.reddam.rdasistente.Servicios.IServices;
import mx.reddam.rdasistente.Servicios.ServicioBase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class UsuarioController{
    public static UsuarioController instance = null;
    public IServices clientServicesRDAsistente;

    private IServices getAPIServiceRDAsistente() {
        return ServicioBase.getClientWigo().create(IServices.class);
    }

    public static UsuarioController getInstance(){
        Object lock = new Object();
        if(instance==null){
            synchronized (lock){
                if(instance == null){
                    instance = new UsuarioController();
                    return instance;
                }else{
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public SignUserResponse altaUsuario(String nombre, String apellidos, String telefono, String correo, String url, String usr, String pass, String facebook, String google, String mail, final ISignUser listener, Context context){
        try{
            final DataUserModelRequest datas= new DataUserModelRequest();
            if(!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !usr.isEmpty() && !pass.isEmpty() && !facebook.isEmpty() && !google.isEmpty() && !mail.isEmpty()){
                datas.apellidos = apellidos;
                datas.nombre = nombre;
                datas.correo=correo;
                datas.telefono = telefono;
                datas.facebook=facebook;
                datas.usr = usr;
                datas.url=url;
                datas.google=google;
                datas.mail=mail;
                datas.pass=pass;
                clientServicesRDAsistente.signUser(datas).enqueue(new Callback<SignUserResponse>() {
                    @Override
                    public void onResponse(Call<SignUserResponse> call, Response<SignUserResponse> response) {
                        if(response.body().getCodigoRespuesta() == EnumTipoRespuesta.Correcto) {
                            if(response.body().getIdUser()>0) {
                                datas.pass = null;
                                listener.successSign(datas);
                            }else {
                                listener.failSign();
                            }
                        }else{
                            listener.failSign();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUserResponse> call, Throwable t) {
                        listener.failSign();
                    }
                });
            }else{
                AlertsHelper.showSimpleAlert(context, R.string.no_empty_data);
            }
        }catch (Exception ex){
            Log.e("UsuarioController", "Error en altaUsuario: "+ex.getMessage());
        }
        return null;
    }

    private UsuarioController(){
        clientServicesRDAsistente = getAPIServiceRDAsistente();
    }
}
