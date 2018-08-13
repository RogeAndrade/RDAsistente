package mx.reddam.rdasistente.Vista.Actividades;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import mx.reddam.rdasistente.Helpers.BottomNavigationViewHelper;
import mx.reddam.rdasistente.R;
import mx.reddam.rdasistente.Vista.Fragments.FragmentFinanzas;
import mx.reddam.rdasistente.Vista.Fragments.FragmentAgenda;
import mx.reddam.rdasistente.Vista.Fragments.FragmentMas;
import mx.reddam.rdasistente.Vista.Fragments.FragmentSettings;
import mx.reddam.rdasistente.Vista.Fragments.FragmentTareas;
import mx.reddam.rdasistente.Vista.Fragments.FragmentHome;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    Toolbar toolbar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadFragment(new FragmentHome(), getString(R.string.tag_fragment_home), false);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        imageView = findViewById(R.id.iv_settings_goto);
        imageView.setOnClickListener(this);
    }

    private boolean loadFragment(Fragment fragment, String tag, boolean addToBack) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(addToBack){
                transaction.addToBackStack(null);
            }else{
                Fragment fragmentRemove = getSupportFragmentManager().findFragmentByTag(getString(R.string.tag_fragment_settings));
                if(fragmentRemove != null) {
                    transaction.remove(fragmentRemove);
                }
            }
            transaction.replace(R.id.fl_navigation_content, fragment, tag).commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        String tag = null;

        switch (item.getItemId()) {
            case R.id.menu_home:
                fragment = new FragmentHome();
                tag = getString(R.string.tag_fragment_home);
                break;

            case R.id.menu_finanzas:
                fragment = new FragmentFinanzas();
                tag = getString(R.string.tag_fragment_finanzas);
                break;

            case R.id.menu_tareas:
                fragment = new FragmentTareas();
                tag = getString(R.string.tag_fragment_tareas);
                break;

            case R.id.menu_agenda:
                fragment = new FragmentAgenda();
                tag = getString(R.string.tag_fragment_agenda);
                break;
            case R.id.menu_mas:
                fragment = new FragmentMas();
                tag = getString(R.string.tag_fragment_mas);
                break;
        }

        return loadFragment(fragment, tag, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_settings_goto:
                try{
                    Fragment fragment = new FragmentSettings();
                    String tag = getString(R.string.tag_fragment_settings);
                    loadFragment(fragment, tag, true);
                }catch (Exception ex){
                    Log.e("MainActivity", "Error en onClick: "+ex.getMessage());
                }
                break;
        }
    }
}
