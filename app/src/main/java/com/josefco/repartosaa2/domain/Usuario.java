package com.josefco.repartosaa2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Usuario implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private String apellido;
    @ColumnInfo
    private String telefono;
    @ColumnInfo
    private String direccion;
//    @ColumnInfo
//    private LocalDate fechareg;
//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    private byte[] image;
    @ColumnInfo
    private double latitud;
    @ColumnInfo
    private double longitud;

//    public Usuario(int id, String nombre, String apellido, String telefono, String direccion, byte[] image, double latitud, double longitud) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.telefono = telefono;
//        this.direccion = direccion;
//        this.image = image;
//        this.latitud = latitud;
//        this.longitud = longitud;
//    }
//
//    public Usuario(int id, String nombre, String apellido, String telefono, String direccion) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.telefono = telefono;
//        this.direccion = direccion;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

//    public LocalDate getFechareg() {
//        return fechareg;
//    }
//
//    public void setFechareg(LocalDate fechareg) {
//        this.fechareg = fechareg;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return nombre +" "+ apellido +", " + telefono +", " + direccion ;
    }
}
