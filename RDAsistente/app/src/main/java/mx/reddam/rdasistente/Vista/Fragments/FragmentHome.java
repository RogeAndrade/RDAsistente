package mx.reddam.rdasistente.Vista.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.reddam.rdasistente.Models.ListaMovimientosModel;
import mx.reddam.rdasistente.Negocio.Controllers.HomeController;
import mx.reddam.rdasistente.R;
import mx.reddam.rdasistente.Vista.Adapters.AdapterRecyclerHome;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class FragmentHome extends Fragment {
    RecyclerView rvHome;
    HomeController controller;
    AdapterRecyclerHome adapter;
    FloatingActionButton fabAddMore;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        controller = HomeController.getInstance();
        rvHome = view.findViewById(R.id.rv_recycler_home);
        rvHome.setHasFixedSize(true);
        ListaMovimientosModel model = controller.fillData();
        adapter = new AdapterRecyclerHome(this.getActivity(), model.getMovimientos());
        rvHome.setAdapter(adapter);
        rvHome.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        fabAddMore = getActivity().findViewById(R.id.fab_add_more);
        if(fabAddMore!=null){
            fabAddMore.setVisibility(View.VISIBLE);
        }
        return view;
    }


}
