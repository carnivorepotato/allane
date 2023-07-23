package org.allane.database.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.allane.model.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class VehicleDaoImpl implements VehicleDao {

    @NonNull
    private DaoFactory daoFactory;

    @Override
    public Integer createNewVehicle(Vehicle vehicle) {
        return daoFactory.getVehicleRepository().save(vehicle).getId();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return daoFactory.getVehicleRepository().getReferenceById(id);
    }
}
