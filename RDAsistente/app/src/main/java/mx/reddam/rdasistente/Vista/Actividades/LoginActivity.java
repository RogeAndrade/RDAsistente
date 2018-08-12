package mx.reddam.rdasistente.Vista.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 04/02/2018.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToRegistro(View view){
        try{
            Intent i = new Intent(this, RegistroActivity.class);
            startActivity(i);
        }catch (Exception ex){
            Log.e("LoginActivity", "Error en goToRegistro: "+ex.getMessage());
        }
    }

    public void goToHome(View view){
        try{
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }catch (Exception ex){
            Log.e("LoginActivity", "Error en goToHome: "+ex.getMessage());
        }
    }
}
