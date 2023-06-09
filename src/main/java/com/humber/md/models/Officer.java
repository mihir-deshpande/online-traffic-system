package com.humber.md.models;


import jakarta.persistence.*;

/**
 * @author Mihir
 * @description This class is used to represent the Officer table in the database.
 * It is mapped to the 'Route' table in the database using Hibernate annotations.
 */
@Entity
@Table(name = "officer")
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    private int officerId;

    @Column(name = "officer_name")
    private String officerName;

    @Column(name = "branch")
    private String branch;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    public Officer(String officerName, String branch, String username, String password) {

        this.officerName = officerName;
        this.branch = branch;
        this.username = username;
        this.password = password;
    }

    public Officer() {
        this("", "", "", "");
    }

    //Getters and Setters
    public int getOfficerId() {
        return officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public String getBranch() {
        return branch;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

