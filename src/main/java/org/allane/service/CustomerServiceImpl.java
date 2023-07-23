package org.allane.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.allane.database.dao.CustomerDao;
import org.allane.model.Customer;
import org.hibernate.ObjectNotFoundException;
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
        try {
            return customerDao.getCustomerById(id);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("Could not find customer with id:" + id, id);
        }
    }

    private void validateCustomer(Customer customer) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.setLenient(false);
            format.parse(customer.getBirthDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date " + customer.getBirthDate() +
                    " has incorrect format or is not a valid date. Valid date format is 'dd.MM.yyyy'");
        }
    }
}
