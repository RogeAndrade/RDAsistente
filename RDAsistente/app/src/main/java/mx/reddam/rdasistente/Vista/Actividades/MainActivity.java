package mx.reddam.rdasistente.Vista.Actividades;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import mx.reddam.rdasistente.Helpers.BottomNavigationViewHelper;
import mx.reddam.rdasistente.R;
import mx.reddam.rdasistente.Vista.Fragments.FragmentFinanzas;
import mx.reddam.rdasistente.Vista.Fragments.FragmentAgenda;
import mx.reddam.rdasistente.Vista.Fragments.FragmentTareas;
import mx.reddam.rdasistente.Vista.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadFragment(new HomeFragment(), getString(R.string.tag_fragment_home));
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.removeShiftMode(navigation);
    }

    private boolean loadFragment(Fragment fragment, String tag) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_navigation_content, fragment, tag)
                    .commit();
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
                fragment = new HomeFragment();
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
        }

        return loadFragment(fragment, tag);
    }
}
