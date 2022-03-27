package com.josefco.repartosaa2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.josefco.repartosaa2.dao.CamionDAO;
import com.josefco.repartosaa2.dao.ConductorDAO;
import com.josefco.repartosaa2.dao.PaqueteDAO;
import com.josefco.repartosaa2.dao.UsuarioDAO;
import com.josefco.repartosaa2.domain.Camion;
import com.josefco.repartosaa2.domain.Conductor;
import com.josefco.repartosaa2.domain.Paquete;
import com.josefco.repartosaa2.domain.Usuario;

@Database(entities = {Usuario.class}, version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioDAO usuarioDAO();
//    public abstract CamionDAO camionDAO();
//    public abstract ConductorDAO conductorDAO();
//    public abstract PaqueteDAO paqueteDAO();
}
