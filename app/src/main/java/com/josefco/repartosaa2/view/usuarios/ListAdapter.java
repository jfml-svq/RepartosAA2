package com.josefco.repartosaa2.view.usuarios;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.contract.conductores.AddEditConductoresContract;
import com.josefco.repartosaa2.domain.Usuario;


import java.io.IOException;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    public List<Usuario> mData;
    public final LayoutInflater mInflater;
    public Context context;


    public ListAdapter(List<Usuario> itemsList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemsList;

    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){

        holder.bindData(mData.get(position));

    }

    public void setItems(List<Usuario> items) {mData = items;}

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        ImageView iconImage;
        TextView nombre, apellido, direccion, telefono;
        CardView cv;

        ViewHolder(View itemView){

            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            nombre = itemView.findViewById(R.id.nombreusuariorv);
            apellido = itemView.findViewById(R.id.apellidousuariorv);
            direccion = itemView.findViewById(R.id.direccionusuariorv);
            telefono = itemView.findViewById(R.id.telefonousuariorv);
            cv = itemView.findViewById(R.id.cv);
            cv.setOnCreateContextMenuListener(this);

        }

        void bindData (final Usuario item){
            nombre.setText(item.getNombre());
            apellido.setText(item.getApellido());
            direccion.setText(item.getDireccion());
            telefono.setText(item.getTelefono());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.add(this.getAdapterPosition(),0,0, "Detalles");
            menu.add(this.getAdapterPosition(),1,1, "Editar");
            menu.add(this.getAdapterPosition(),2,2, "Borrar");
            menu.add(this.getAdapterPosition(),3,3, "Añadir a Fav");
        }
    }

}
