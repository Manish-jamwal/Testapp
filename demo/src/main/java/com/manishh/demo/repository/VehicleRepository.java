package com.manishh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manishh.demo.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
}
