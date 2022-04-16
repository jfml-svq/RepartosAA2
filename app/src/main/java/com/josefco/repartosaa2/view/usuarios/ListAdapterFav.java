package com.josefco.repartosaa2.view.usuarios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.josefco.repartosaa2.R;
import com.josefco.repartosaa2.database.AppDatabase;
import com.josefco.repartosaa2.domain.UsuarioFav;

import java.util.List;

public class ListAdapterFav extends RecyclerView.Adapter<ListAdapterFav.ViewHolder> {

    public List<UsuarioFav> mData;
    public final LayoutInflater mInflater;
    public Context context;

    public ListAdapterFav(List<UsuarioFav> itemsList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemsList;

    }

    @Override
    public ListAdapterFav.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element_fav, null);
        return new ListAdapterFav.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterFav.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<UsuarioFav> items) {
        mData = items;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView iconImage;
        TextView nombre, apellido, direccion, telefono;
        ImageButton btndelete;

        ViewHolder(View itemView) {

            super(itemView);

            iconImage = itemView.findViewById(R.id.iconImageViewfav);
            nombre = itemView.findViewById(R.id.nombreusuariorvfav);
            apellido = itemView.findViewById(R.id.apellidousuariorvfav);
            direccion = itemView.findViewById(R.id.direccionusuariorvfav);
            telefono = itemView.findViewById(R.id.telefonousuariorvfav);
            btndelete = itemView.findViewById(R.id.deleteFav);
            btndelete.setOnClickListener(this);

        }

        void bindData(final UsuarioFav item) {
            nombre.setText(item.getNombre());
            apellido.setText(item.getApellido());
            direccion.setText(item.getDireccion());
            telefono.setText(item.getTelefono());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            final UsuarioFav usuarioFav = mData.get(position);

            AppDatabase db = Room.databaseBuilder(context,
                    AppDatabase.class, "repartos").allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
            db.usuarioFavDAO().delete(usuarioFav);
            mData.remove(position);
            notifyDataSetChanged();


        }
    }

}
