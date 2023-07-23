package org.allane.mapper;

import org.allane.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {
    Vehicle map(org.openapitools.model.Vehicle vehicle);

    org.openapitools.model.Vehicle map(Vehicle vehicleById);
}
