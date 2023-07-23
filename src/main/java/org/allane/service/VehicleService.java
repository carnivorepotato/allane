package org.allane.service;

import org.allane.model.Vehicle;
import org.allane.model.Brand;
import org.hibernate.ObjectNotFoundException;

import java.util.List;

public interface VehicleService {
    /**
     * Creates a new vehicle
     * @param vehicle Vehicle details
     * @return New vehicle id
     */
    Integer createNewVehicle(Vehicle vehicle);

    /**
     * Returns vehicle with given id
     * @param id Vehicle id
     * @return Vehicle with given id
     * @throws ObjectNotFoundException Could not find vehicle with given id
     */
    Vehicle findVehicleById(Integer id);

    /**
     * Returns vehicle brands with model names
     * @return List of vehicle brands with model names
     */
    List<Brand> getAllBrandsAndModels();
}
