package org.allane.mapper;

import org.allane.model.Customer;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {

    @Spy
    private CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    public void testMapCustomerToDto() {
        Customer testSubject = getCustomer();
        org.openapitools.model.Customer result = mapper.map(testSubject);

        assertEquals(result.getFirstName(), testSubject.getFirstName());
        assertEquals(result.getLastName(), testSubject.getLastName());
        assertEquals(result.getBirthDate(), testSubject.getBirthDate());
    }

    @Test
    public void testMapCustomerFromDto() {
        org.openapitools.model.Customer testSubject = getCustomerDto();
        Customer result = mapper.map(testSubject);

        assertEquals(result.getFirstName(), testSubject.getFirstName());
        assertEquals(result.getLastName(), testSubject.getLastName());
        assertEquals(result.getBirthDate(), testSubject.getBirthDate());
    }

    private Customer getCustomer() {
        Customer result = new Customer();
        result.setFirstName("Jake");
        result.setLastName("Stone");
        result.setBirthDate("19.10.1946");

        return result;
    }

    private org.openapitools.model.Customer getCustomerDto() {
        return new org.openapitools.model.Customer(
                "Stone",
                "Jake",
                "26.10.1947");
    }
}