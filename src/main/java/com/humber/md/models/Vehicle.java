package com.humber.md.models;


import jakarta.persistence.*;

/**
 * @author Mihir
 * @description This class is used to represent the Vehicle table in the database.
 * It is mapped to the 'Route' table in the database using Hibernate annotations.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id", nullable = false, unique = true)
    private int vehicleId;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    //Constructors
    public Vehicle(int vehicleId, String make, String model, int year, String ownerName) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerName = ownerName;
    }

    public Vehicle() {

    }


    //Getters and Setters
    public int getVehicleId() {
        return vehicleId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


}

