package com.josefco.repartosaa2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Camion implements Serializable {

    //@PrimaryKey(autoGenerate = true)
    private String id;
    @ColumnInfo
    private String matricula;
    @ColumnInfo
    private String modelo;
    @ColumnInfo
    private String marca;
    @ColumnInfo
    private int gasolina;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Camion(String id, String matricula, String modelo, String marca, int gasolina) {
        this.id = id;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.gasolina = gasolina;
    }

    public Camion(String matricula, String modelo, String marca, int gasolina) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.gasolina = gasolina;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    @Override
    public String toString() {
        return "[ " + matricula + " ]  [ " + marca +" ]  [ " + modelo + " ]";
    }
}
