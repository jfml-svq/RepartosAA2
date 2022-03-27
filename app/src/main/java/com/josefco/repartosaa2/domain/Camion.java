package com.josefco.repartosaa2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Camion {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String matricula;
    @ColumnInfo
    private String modelo;
    @ColumnInfo
    private String marca;
    @ColumnInfo
    private int gasolina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Camion(int id, String matricula, String modelo, String marca, int gasolina) {
        this.id = id;
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
        return "Camion{" +" matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
