package com.manishh.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name = "registration_number")
    private String registration_number;

    @Column(name = "model")
    private String model;

    @Column(name = "km_ridden")
    private int km_ridden;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKm_ridden() {
        return km_ridden;
    }

    public void setKm_ridden(int km_ridden) {
        this.km_ridden = km_ridden;
    }

    public Vehicle(Long uid, String registration_number, String model, int km_ridden) {
        this.uid = uid;
        this.registration_number = registration_number;
        this.model = model;
        this.km_ridden = km_ridden;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle [uid=" + uid + ", registration_number=" + registration_number + ", model=" + model
                + ", km_ridden=" + km_ridden + "]";
    }

    



    



}
