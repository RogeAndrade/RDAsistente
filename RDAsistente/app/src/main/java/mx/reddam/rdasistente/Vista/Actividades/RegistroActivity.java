package mx.reddam.rdasistente.Vista.Actividades;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.reddam.rdasistente.Helpers.AlertsHelper;
import mx.reddam.rdasistente.Helpers.UtilitiesHelper;
import mx.reddam.rdasistente.Interfaces.IAlertAccept;
import mx.reddam.rdasistente.Interfaces.ISignUser;
import mx.reddam.rdasistente.Models.DataUserModelRequest;
import mx.reddam.rdasistente.Negocio.Controllers.UsuarioController;
import mx.reddam.rdasistente.Persistecia.Repositorios.RealmRepositorio;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 04/02/2018.
 */

public class RegistroActivity extends AppCompatActivity implements ISignUser{
    private int PERMISSIONS = 1;
    UsuarioController controller;
    EditText etName, etLastame, etMail, etUsr, etPsw;
    String name, lastName, mail, usr, psw, phone;
    RealmRepositorio repositorio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        repositorio = RealmRepositorio.getInstance();
    }

    @Override
    public void successSign(DataUserModelRequest usuario) {
        AlertsHelper.showAlertWithAction(this, getResources().getString(R.string.text_correct_sign_main), getResources().getString(R.string.ok_alert), new IAlertAccept() {
            @Override
            public void acceptAlert() {
                Intent i = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public void failSign() {
        Toast.makeText(this, "NO", Toast.LENGTH_LONG).show();
    }


    @SuppressLint("MissingPermission")
    public void signUser(View vista){
        try{
            String[] PERMISSIONS_ALL = {Manifest.permission.READ_PHONE_STATE};
            if(!UtilitiesHelper.hasPermissions(this, PERMISSIONS_ALL)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_ALL, PERMISSIONS);
            }else{
                etName = findViewById(R.id.et_name_sign);
                etLastame = findViewById(R.id.et_last_name_sign);
                etMail = findViewById(R.id.et_mail_sign);
                etUsr = findViewById(R.id.et_usr_sign);
                etPsw = findViewById(R.id.et_pass_sign);
                name=etName.getText().toString();
                lastName = etLastame.getText().toString();
                mail = etMail.getText().toString();
                usr=etUsr.getText().toString();
                psw=etPsw.getText().toString();
                TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                phone = tMgr.getLine1Number();
                controller = UsuarioController.getInstance();
                controller.altaUsuario(name, lastName, phone, mail, null, usr,psw, "0", "0", "1", this, this);
            }
        }catch (Exception ex){
            Log.e("RegistroActivity", "Error en signUser: "+ex.getMessage());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSIONS){
            signUser(null);
        }
    }
}
