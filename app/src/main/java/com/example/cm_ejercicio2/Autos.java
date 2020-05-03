package com.example.cm_ejercicio2;

import android.content.Context;

import java.io.Serializable;

public class Autos implements Serializable {
    String ID, model,brand,status;
    int year;
    //Context context;


    public Autos(String ID, String model, String brand, String status, int year) {
        this.ID = ID;
        this.model = model;
        this.brand = brand;
        this.status = status;
        this.year = year;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
