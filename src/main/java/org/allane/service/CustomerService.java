package org.allane.service;

import org.allane.model.Customer;

public interface CustomerService {
    /**
     * @param customer
     * @return
     * @throws IllegalArgumentException not parsable birthdate specified
     */
    Integer createNewCustomer(Customer customer);

    /**
     *
     * @param id
     * @return
     */
    Customer findCustomerById(Integer id);
}
