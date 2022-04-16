package com.josefco.repartosaa2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.josefco.repartosaa2.dao.CamionDAO;
import com.josefco.repartosaa2.dao.ConductorDAO;
import com.josefco.repartosaa2.dao.PaqueteDAO;
import com.josefco.repartosaa2.dao.UsuarioDAO;
import com.josefco.repartosaa2.dao.UsuarioFavDAO;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.domain.Usuario;
import com.josefco.repartosaa2.domain.UsuarioFav;

@Database(entities = {UsuarioFav.class}, version = 2 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioFavDAO usuarioFavDAO();
}
