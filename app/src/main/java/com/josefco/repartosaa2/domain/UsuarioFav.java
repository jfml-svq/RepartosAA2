package com.josefco.repartosaa2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class UsuarioFav {


    @PrimaryKey(autoGenerate = true)
    private int id_fav;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private String apellido;
    @ColumnInfo
    private String telefono;
    @ColumnInfo
    private String direccion;
    @ColumnInfo
    private String email;

    public UsuarioFav(String nombre, String apellido, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public UsuarioFav() {
    }

    public int getId_fav() {
        return id_fav;
    }

    public void setId_fav(int id_fav) {
        this.id_fav = id_fav;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
