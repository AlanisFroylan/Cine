package com.example.froylan.cine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by froylan on 3/12/16.
 */

public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.ViewHolder> {
    private List<Ciudad> ciudades;
    private Context context;

    public CiudadAdapter(List<Ciudad> ciudades, Context context) {
        this.ciudades = ciudades;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ciudad,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ciudad ciudad=ciudades.get(position);
        holder.city.setText(ciudad.getNombre());
    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView city;
        public ViewHolder(View itemView) {
            super(itemView);
            city=(TextView)itemView.findViewById(R.id.ciudad);
        }

    }
}
