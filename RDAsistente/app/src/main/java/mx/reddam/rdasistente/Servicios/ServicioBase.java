package mx.reddam.rdasistente.Servicios;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class ServicioBase {
    private static Retrofit retrofitAsistente = null;

    public static Retrofit getClientWigo() {
        try {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            httpClient.connectTimeout(60, TimeUnit.SECONDS);
            httpClient.readTimeout(60,TimeUnit.SECONDS);
            if (retrofitAsistente == null) {
                retrofitAsistente = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL_RDASISTENTE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
            }
        }catch (Exception ex){
            Log.e("ServiceBase", "Error en getClientWigo: "+ex.getMessage());
        }
        return retrofitAsistente;
    }
}
