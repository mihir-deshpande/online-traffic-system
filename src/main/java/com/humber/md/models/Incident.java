package com.humber.md.models;

import jakarta.persistence.*;


/**
 * @author Mihir
 * @description This class is used to represent the Incident table in the database.
 * It is mapped to the 'Route' table in the database using Hibernate annotations.
 */
@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private int incidentId;

    @Column(name = "incident_date")
    private String incidentDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;

    public Incident() {}

    public Incident(String incidentDate, Route route, Vehicle vehicle, String description, Officer officer) {
        this.incidentDate = incidentDate;
        this.route = route;
        this.vehicle = vehicle;
        this.description = description;
        this.officer = officer;
    }

    // Getters and setters
    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }
}

