package mx.reddam.rdasistente.Vista.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.reddam.rdasistente.Negocio.Controllers.MainController;
import mx.reddam.rdasistente.R;
import mx.reddam.rdasistente.Vista.Adapters.AdapterRecyclerMore;

/**
 * Created by Rogelio Andrade on 12/08/2018.
 */

public class FragmentMas extends Fragment {
    MainController controller;
    RecyclerView rvMoreOptions;
    AdapterRecyclerMore adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_mas, container, false);
        controller = MainController.getInstance();
        rvMoreOptions = view.findViewById(R.id.rv_more_options);
        adapter = new AdapterRecyclerMore(getActivity(), controller.getMoreActions());
        rvMoreOptions.setAdapter(adapter);
        rvMoreOptions.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}
