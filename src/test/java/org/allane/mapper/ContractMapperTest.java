package org.allane.mapper;

import org.allane.model.Contract;
import org.allane.model.Customer;
import org.allane.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContractMapperTest {

    @Spy
    private ContractMapper mapper = Mappers.getMapper(ContractMapper.class);

    @Test
    public void testMapContractFromDto() {
        org.openapitools.model.Contract testSubject = getContractDto();

        Contract result = mapper.map(testSubject);

        assertEquals(result.getContractNumber(), testSubject.getContractNumber());
        assertEquals(result.getCustomer().getId(), testSubject.getCustomerId());
        assertEquals(result.getVehicle().getId(), testSubject.getVehicleId());
    }

    @Test
    public void testMapContractToDto() {
        Contract testSubject = getContract();

        org.openapitools.model.Contract result = mapper.map(testSubject);

        testResultEqualsExpected(result, testSubject);
    }

    @Test
    public void testMapContractListToDtoList() {
        Contract testSubject = getContract();

        List<org.openapitools.model.Contract> resultList = mapper.map(List.of(testSubject, testSubject, testSubject));
        resultList.forEach(result -> {
            testResultEqualsExpected(result, testSubject);
        });
    }

    private Contract getContract() {
        Contract result = new Contract();
        result.setContractNumber(122333);
        result.setMonthlyRate(350.0);
        Customer customer = new Customer();
        customer.setFirstName("Bob");
        customer.setLastName("Jameson");
        customer.setBirthDate("10.10.2010");
        result.setCustomer(customer);
        Vehicle vehicle = new Vehicle();
        vehicle.setVin("X12345C");
        vehicle.setBrand("BMW");
        vehicle.setModel("X150");
        vehicle.setProductionYear("2033");
        vehicle.setPrice(100000.00);
        result.setVehicle(vehicle);

        return result;
    }

    private org.openapitools.model.Contract getContractDto() {
        org.openapitools.model.Contract result = new org.openapitools.model.Contract();
        result.setContractNumber(322111);
        result.setMonthlyRate(666.33);
        result.setVehicleId(1);
        result.setCustomerId(2);

        return result;
    }

    private void testResultEqualsExpected(org.openapitools.model.Contract result, Contract testSubject) {
        String expectedCustomerName = testSubject.getCustomer().getFirstName() + " "
                + testSubject.getCustomer().getLastName();
        String expectedVehicleName = testSubject.getVehicle().getBrand() + " "
                + testSubject.getVehicle().getModel() + " ("
                + testSubject.getVehicle().getProductionYear() + ")";

        assertEquals(result.getContractNumber(), testSubject.getContractNumber());
        assertEquals(result.getMonthlyRate(), testSubject.getMonthlyRate());
        assertEquals(result.getVin(), testSubject.getVehicle().getVin());
        assertEquals(result.getCustomerName(), expectedCustomerName);
        assertEquals(result.getVehicleName(), expectedVehicleName);
    }
}