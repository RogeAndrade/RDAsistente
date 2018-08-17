package mx.reddam.rdasistente.Vista.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 12/08/2018.
 */

public class FragmentSettings extends Fragment {
    CircleImageView ivProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_settings, container, false);
        ivProfile = view.findViewById(R.id.ivc_image_profile);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(ivProfile);
        return view;
    }
}
