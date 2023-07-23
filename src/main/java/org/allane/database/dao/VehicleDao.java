package org.allane.database.dao;

import org.allane.model.Vehicle;

public interface VehicleDao {
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
     */
    Vehicle getVehicleById(Integer id);
}
