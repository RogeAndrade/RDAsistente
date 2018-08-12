package mx.reddam.rdasistente;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import mx.reddam.rdasistente.Vista.Actividades.LoginActivity;

/**
 * Created by Rogelio Andrade on 04/02/2018.
 */

public class SplashActivity extends AppCompatActivity {
    private int timeWaitSplash = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, timeWaitSplash);
    }
}
