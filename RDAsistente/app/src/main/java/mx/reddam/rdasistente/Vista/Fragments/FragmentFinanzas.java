package mx.reddam.rdasistente.Vista.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mx.reddam.rdasistente.Models.MovimientosContentModel;
import mx.reddam.rdasistente.Negocio.Controllers.FinanzasController;
import mx.reddam.rdasistente.R;
import mx.reddam.rdasistente.Vista.Adapters.AdapterRecyclerContent;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class FragmentFinanzas extends Fragment {
    RecyclerView rvFinanzas;
    FinanzasController controller;
    AdapterRecyclerContent adapter;
    FloatingActionButton fabAddMore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_finanzas, container, false);
        controller = FinanzasController.getInstance();
        rvFinanzas = view.findViewById(R.id.rv_recycler_finanzas);
        rvFinanzas.setHasFixedSize(true);
        List<MovimientosContentModel> model = controller.getContentFinanzas();
        adapter = new AdapterRecyclerContent(this.getActivity(), model);
        rvFinanzas.setAdapter(adapter);
        rvFinanzas.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        fabAddMore = getActivity().findViewById(R.id.fab_add_more);
        if(fabAddMore!=null){
            fabAddMore.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
