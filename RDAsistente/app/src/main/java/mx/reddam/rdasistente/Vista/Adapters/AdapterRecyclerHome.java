package mx.reddam.rdasistente.Vista.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.reddam.rdasistente.Models.TiposMovimientosModel;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class AdapterRecyclerHome extends RecyclerView.Adapter<AdapterRecyclerHome.ViewHolder>{
    List<TiposMovimientosModel> movimientos;
    Context context;

    public AdapterRecyclerHome(Context context, List<TiposMovimientosModel> movimientos){
        this.context=context;
        this.movimientos=movimientos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_home, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TiposMovimientosModel model = movimientos.get(position);
        if(model!= null){
            Picasso.get().load(model.getImagen()).fit().into(holder.imgDesc);
            holder.tvDesc.setText(model.getDescripcion());
            holder.tvTitulo.setText(model.getTitulo());
        }
    }

    @Override
    public int getItemCount() {
        return movimientos!= null ? movimientos.size(): 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDesc;
        TextView tvTitulo;
        ImageView imgDesc;

        ViewHolder(View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tv_desc_home);
            tvTitulo = itemView.findViewById(R.id.tv_title_home);
            imgDesc = itemView.findViewById(R.id.iv_image_home);
        }
    }
}
