package com.josefco.repartosaa2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Paquete implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private String id;
    @ColumnInfo
    private int ancho;
    @ColumnInfo
    private int largo;
    @ColumnInfo
    private int alto;
    @ColumnInfo
    private int peso;
    @ColumnInfo
    private String color;

    public Paquete(int ancho, int largo, int alto, int peso, String color) {
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
        this.peso = peso;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Id=" + id;
    }
}
