package org.allane.database.dao;

import org.allane.model.Customer;

public interface CustomerDao {

    Integer createNewCustomer(Customer customer);

    Customer getCustomerById(Integer id);
}
