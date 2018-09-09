package mx.reddam.rdasistente.Persistecia.Repositorios;

import android.util.Log;

import com.google.gson.Gson;

import io.realm.Realm;
import mx.reddam.rdasistente.Models.DataUserModelRequest;
import mx.reddam.rdasistente.Persistecia.Modelos.DatosUsuarioModelo;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class RealmRepositorio {
    private static RealmRepositorio instance;
    private final Realm realm;

    private RealmRepositorio() {
        realm = Realm.getDefaultInstance();
    }

    public static RealmRepositorio getInstance() {

        if (instance == null) {
            instance = new RealmRepositorio();
        }
        return instance;
    }

    public boolean saveUsuario(DataUserModelRequest datos){
        try{
            realm.beginTransaction();
            Gson gson = new Gson();
            String json = gson.toJson(datos);
            realm.createAllFromJson(DatosUsuarioModelo.class, json);
        }catch (Exception ex){
            Log.e("RealmRepositorio", "Error en saveUsuario: "+ex.getMessage());
        }finally {
            realm.commitTransaction();
        }
        return false;
    }
}
