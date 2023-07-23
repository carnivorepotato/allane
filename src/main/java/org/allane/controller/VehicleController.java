package org.allane.controller;

import org.allane.mapper.VehicleMapper;
import org.allane.service.VehicleService;
import org.hibernate.ObjectNotFoundException;
import org.openapitools.api.VehicleApi;
import org.openapitools.model.Brand;
import org.openapitools.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity getVehicleById(Integer id) {
        try {
            return new ResponseEntity<>(
                    mapper.map(service.findVehicleById(id)),
                    HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(
                    e.getLocalizedMessage(),
                    HttpStatus.NOT_ACCEPTABLE);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(
                    e.getEntityName(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<Brand>> getAllBrandsAndModels() {
        return new ResponseEntity<>(mapper.map(service.getAllBrandsAndModels()), HttpStatus.OK);
    }
}
