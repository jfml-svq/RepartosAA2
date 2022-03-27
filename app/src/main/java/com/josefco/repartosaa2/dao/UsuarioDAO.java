package com.josefco.repartosaa2.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.josefco.repartosaa2.domain.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuario WHERE nombre = :nombre")
    List<Usuario> findByNombre(String nombre);

    @Insert
    void insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);
}
