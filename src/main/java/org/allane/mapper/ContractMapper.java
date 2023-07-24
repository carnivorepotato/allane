package org.allane.mapper;

import org.allane.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContractMapper {

    @Mapping(target = "contractNumber", source = "contractNumber")
    @Mapping(target = "monthlyRate", source = "monthlyRate")
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "vehicle.id", source = "vehicleId")
    public abstract Contract map(org.openapitools.model.Contract contract);

    public org.openapitools.model.Contract map(Contract contract) {
        org.openapitools.model.Contract result = new org.openapitools.model.Contract();
        result.setContractNumber(contract.getContractNumber());
        result.setMonthlyRate(contract.getMonthlyRate());
        result.setCustomerId(contract.getCustomer().getId());
        result.setCustomerName(contract.getCustomer().getFirstName() + " " + contract.getCustomer().getLastName());
        result.setVehicleId(contract.getVehicle().getId());
        result.setVehicleName(
                contract.getVehicle().getBrand() + " "
                + contract.getVehicle().getModel() + " ("
                + contract.getVehicle().getProductionYear() + ")");
        result.setVin(contract.getVehicle().getVin());
        result.setPrice(contract.getVehicle().getPrice());
        return result;
    }

    public abstract List<org.openapitools.model.Contract> map(List<Contract> allContracts);
}
