package org.allane.controller;

import org.allane.mapper.VehicleMapper;
import org.allane.service.VehicleService;
import org.openapitools.api.VehicleApi;
import org.openapitools.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController implements VehicleApi {

    @Autowired
    private VehicleMapper mapper;
    @Autowired
    private VehicleService service;

    @Override
    public ResponseEntity<Integer> createVehicle(Vehicle vehicle) {
        return new ResponseEntity<>(
                service.createNewVehicle(mapper.map(vehicle)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vehicle> getVehicleById(Integer id) {
        return new ResponseEntity<>(
                mapper.map(service.findVehicleById(id)),
                HttpStatus.OK);
    }
}
