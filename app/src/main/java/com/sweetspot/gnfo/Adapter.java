package com.sweetspot.gnfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> implements View.OnClickListener {

    ArrayList<lugares> listDatos;
    private View.OnClickListener listener;

    public Adapter(ArrayList<lugares> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cantante,null,false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.etnom.setText(listDatos.get(position).getNomLugar());
        holder.etcodigo.setText("Codigo: "+listDatos.get(position).getCode());


    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView etnom;
        TextView etcodigo;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            etnom = (TextView) itemView.findViewById(R.id.lugar);
            etcodigo = (TextView) itemView.findViewById(R.id.codigo);
        }

    }
}