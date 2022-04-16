package com.josefco.repartosaa2.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.josefco.repartosaa2.domain.UsuarioFav;

import java.util.List;

@Dao
public interface UsuarioFavDAO {

    @Insert
    void insert (UsuarioFav usuarioFav);


    @Query("SELECT * FROM USUARIOFAV")
    List<UsuarioFav> getAll();

    @Delete
    void delete(UsuarioFav usuarioFav);

}
