package mx.reddam.rdasistente.Vista.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 12/08/2018.
 */

public class FragmentSettings extends Fragment {
    FloatingActionButton fabAddMore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_settings, container, false);
        fabAddMore = getActivity().findViewById(R.id.fab_add_more);
        if(fabAddMore!=null){
            fabAddMore.setVisibility(View.INVISIBLE);
        }
        return view;
    }
}
