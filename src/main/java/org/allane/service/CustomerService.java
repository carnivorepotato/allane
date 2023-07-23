package org.allane.service;

import org.allane.model.Customer;
import org.hibernate.ObjectNotFoundException;

public interface CustomerService {
    /**
     * Creates a new customer
     * @param customer Customer details
     * @return New customer id
     * @throws IllegalArgumentException not parsable birthdate specified
     */
    Integer createNewCustomer(Customer customer);

    /**
     * Returns customer with given id
     * @param id Customer id
     * @return Customer with given id
     * @throws ObjectNotFoundException Could not find customer with given id
     */
    Customer findCustomerById(Integer id);
}
