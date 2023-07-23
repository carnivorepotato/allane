package org.allane.service;

import lombok.RequiredArgsConstructor;
import org.allane.database.dao.VehicleDao;
import org.allane.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleDao vehicleDao;

    @Override
    public Integer createNewVehicle(Vehicle vehicle) {
        return vehicleDao.createNewVehicle(vehicle);
    }

    @Override
    public Vehicle findVehicleById(Integer id) {
        return vehicleDao.getVehicleById(id);
    }
}