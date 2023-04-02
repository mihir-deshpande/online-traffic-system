package com.humber.md.models;

import javax.persistence.*;

/**
 * @author Mihir
 * @description This class is used to represent the Route table in the database.
 * It is mapped to the 'Route' table in the database using Hibernate annotations.
 */
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private int routeId;

    @Column(name = "route_name")
    private String routeName;

    @Column(name = "location")
    private String location;

    public Route() {}

    public Route(String routeName, String location) {
        this.routeName = routeName;
        this.location = location;
    }
     //Getters and Setters
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

