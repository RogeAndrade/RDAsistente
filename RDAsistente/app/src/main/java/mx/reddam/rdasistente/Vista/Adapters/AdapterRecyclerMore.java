package mx.reddam.rdasistente.Vista.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.reddam.rdasistente.Models.MoreActionsModel;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 14/08/2018.
 */

public class AdapterRecyclerMore extends RecyclerView.Adapter<AdapterRecyclerMore.ViewHolder>{
    Context context;
    List<MoreActionsModel> moreOptions;

    public AdapterRecyclerMore(Context context, List<MoreActionsModel> moreOptions){
        this.context=context;
        this.moreOptions=moreOptions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_more, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoreActionsModel model = moreOptions.get(position);
        if(model != null){
            Picasso.get().load(model.getImage()).into(holder.imgDesc);
            holder.tvTitulo.setText(model.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return moreOptions != null ? moreOptions.size(): 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        ImageView imgDesc;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tv_title_more);
            imgDesc = itemView.findViewById(R.id.iv_image_more);
        }
    }
}
