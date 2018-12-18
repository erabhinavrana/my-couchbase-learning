package com.abhi.couchbase.model;

import java.io.Serializable;

/**
 * Created by Abhinav on 12/18/2018.
 */
public class Vehicle implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String type;
    private String make;
    private String year;
    private String model;

    public Vehicle(int id, String type, String make, String year, String model) {
        this.id = id;
        this.type = type;
        this.make = make;
        this.year = year;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", make='" + make + '\'' +
                ", year='" + year + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
