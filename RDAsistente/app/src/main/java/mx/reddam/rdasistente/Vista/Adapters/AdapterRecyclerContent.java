package mx.reddam.rdasistente.Vista.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.reddam.rdasistente.Models.MovimientosContentModel;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 10/08/2018.
 */

public class AdapterRecyclerContent extends RecyclerView.Adapter<AdapterRecyclerContent.ViewHolder>{
    Context context;
    List<MovimientosContentModel> movimientos;


    public AdapterRecyclerContent(Context context, List<MovimientosContentModel> movimientos){
        this.context=context;
        this.movimientos=movimientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_content, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovimientosContentModel model = movimientos.get(position);
        if(model!= null){
        }
    }

    @Override
    public int getItemCount() {
        return movimientos!= null ? movimientos.size(): 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDesc;
        ImageView imgDesc;

        ViewHolder(View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tv_desc_home);
            imgDesc = itemView.findViewById(R.id.iv_image_home);
        }
    }
}
