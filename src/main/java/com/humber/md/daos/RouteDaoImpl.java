package com.humber.md.daos;

import com.humber.md.models.Route;
import com.humber.md.models.Vehicle;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {

    @Autowired
    EntityManager entityManager;

    // Return all routes
    @Override
    public List<Route> findAll() {
        TypedQuery<Route> query = entityManager.createQuery("from Route", Route.class);
        return query.getResultList();
    }


    // Get route by id
    @Override
    public Route getRouteById(int routeId) {
        TypedQuery<Route> query = entityManager.createQuery("from Route where id = :id", Route.class);
        query.setParameter("id", routeId);
        return query.getSingleResult();
    }
}
