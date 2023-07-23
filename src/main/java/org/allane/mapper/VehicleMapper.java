package org.allane.mapper;

import org.allane.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {
    Vehicle map(org.openapitools.model.Vehicle vehicle);

    org.openapitools.model.Vehicle map(Vehicle vehicleById);

    Brand map(org.allane.model.Brand brand);

    List<Brand> map(List<org.allane.model.Brand> allBrandsAndModels);
}
