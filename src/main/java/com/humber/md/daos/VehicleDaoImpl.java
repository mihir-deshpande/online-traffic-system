package com.humber.md.daos;

import com.humber.md.models.Vehicle;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao{

    @PersistenceContext
    private EntityManager entityManager;

    // Return all vehicles
    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createQuery("from Vehicle", Vehicle.class);
        return query.getResultList();
    }


    // Find a vehicle by id
    @Override
    public Vehicle getVehicleById(int id) {
        TypedQuery<Vehicle> query = entityManager.createQuery("from Vehicle where id = :id", Vehicle.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
