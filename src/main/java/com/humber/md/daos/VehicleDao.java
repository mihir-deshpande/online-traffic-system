package com.humber.md.daos;

import com.humber.md.models.Vehicle;

import java.util.List;

public interface VehicleDao {

    List<Vehicle> findAll();
    Vehicle getVehicleById(int id);


}
