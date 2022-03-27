package com.josefco.repartosaa2.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.josefco.repartosaa2.domain.Paquete;

import java.util.List;

@Dao
public interface PaqueteDAO {
    @Query("SELECT * FROM paquete")
    List<Paquete> getAll();

    @Query("SELECT * FROM paquete WHERE id = :id")
    List<Paquete> findById(int id);

    @Insert
    void insert(Paquete paquete);

    @Update
    void update(Paquete paquete);

    @Delete
    void delete(Paquete paquete);
}
