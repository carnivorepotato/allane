package org.allane.database.dao;

import org.allane.model.Vehicle;

public interface VehicleDao {
    Integer createNewVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Integer id);
}
