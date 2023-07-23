package org.allane.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.allane.database.dao.BrandDao;
import org.allane.database.dao.VehicleDao;
import org.allane.model.Brand;
import org.allane.model.Vehicle;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleDao vehicleDao;
    private final BrandDao brandDao;

    @Override
    public Integer createNewVehicle(Vehicle vehicle) {
        return vehicleDao.createNewVehicle(vehicle);
    }

    @Override
    public Vehicle findVehicleById(Integer id) {
        try {
            return vehicleDao.getVehicleById(id);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("Could not find vehicle with id:" + id, id);
        }
    }

    @Override
    public List<Brand> getAllBrandsAndModels() {
        return brandDao.getAllBrandsAndModels();
    }
}