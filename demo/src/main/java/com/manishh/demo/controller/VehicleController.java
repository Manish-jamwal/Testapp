package com.manishh.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manishh.demo.model.Vehicle;
import com.manishh.demo.repository.VehicleRepository;




@RestController
@RequestMapping("/api")
public class VehicleController {
    
    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping("/vehicles")
    public String CreateNewVehicle(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "Vehicle created successfully";
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleRepository.findAll().forEach(vehicleList::add);
        return new ResponseEntity<List<Vehicle>>(vehicleList,HttpStatus.OK);
    }

    @GetMapping("/vehicles/{uid}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long uid){
        Optional<Vehicle> veh = vehicleRepository.findById(uid);

        if(veh.isPresent()){
            return new ResponseEntity<Vehicle>(veh.get(),HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/vehicles/{uid}")
    public String updateVehicleById(@PathVariable long uid,@RequestBody Vehicle vehicle){
        Optional<Vehicle> veh = vehicleRepository.findById(uid);
        if(veh.isPresent()){
            Vehicle existveh = veh.get();
            existveh.setRegistration_number(vehicle.getRegistration_number());
            existveh.setModel(vehicle.getModel());
            existveh.setKm_ridden(vehicle.getKm_ridden());
            vehicleRepository.save(existveh);
            return "Vehicle details updated successfully";
        }
        else{
            return "Vehicle details does not found against id " + uid;
        }

    }


    @DeleteMapping("/vehicles/{uid}")
    public String deleteVehicleById(@PathVariable Long uid){
        vehicleRepository.deleteById(uid);
        return "Vehicle deleted successfully";
    }


}
