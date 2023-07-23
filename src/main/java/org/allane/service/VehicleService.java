package org.allane.service;

import org.allane.model.Vehicle;

public interface VehicleService {
    /**
     *
     * @param vehicle
     * @return
     */
    Integer createNewVehicle(Vehicle vehicle);

    /**
     *
     * @param id
     * @return
     */
    Vehicle findVehicleById(Integer id);
}
