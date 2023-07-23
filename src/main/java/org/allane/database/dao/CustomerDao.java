package org.allane.database.dao;

import org.allane.model.Customer;

public interface CustomerDao {

    /**
     * Creates a new customer
     * @param customer Customer details
     * @return New customer id
     */
    Integer createNewCustomer(Customer customer);

    /**
     * Returns customer with given id
     * @param id Customer id
     * @return Customer with given id
     */
    Customer getCustomerById(Integer id);
}
