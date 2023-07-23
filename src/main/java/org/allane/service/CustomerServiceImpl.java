package org.allane.service;

import lombok.RequiredArgsConstructor;
import org.allane.database.dao.CustomerDao;
import org.allane.model.Customer;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Override
    public Integer createNewCustomer(Customer customer) {
        validateCustomer(customer);
        return customerDao.createNewCustomer(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    private void validateCustomer(Customer customer) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            format.setLenient(false);
            format.parse(customer.getBirthDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date " + customer.getBirthDate() +
                    " has incorrect format or is not a valid date. Valid date format is 'dd-MM-yyyy'");
        }
    }
}
