package com.josefco.repartosaa2.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.JsonAdapter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario implements Serializable {



    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private String apellido;
    @ColumnInfo
    private String telefono;
    @ColumnInfo
    private String direccion;
    @ColumnInfo
    private double lat;
    @ColumnInfo
    private double lon;
    @ColumnInfo
    private String email;

    public Usuario(String nombre, String apellido, String telefono, String direccion, double lat, double lon, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.lat = lat;
        this.lon = lon;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return nombre +" "+ apellido +", " + telefono +", " + direccion ;
    }
}
