package org.allane.controller;


import org.allane.mapper.CustomerMapper;
import org.allane.service.CustomerService;
import org.hibernate.ObjectNotFoundException;
import org.openapitools.api.CustomerApi;
import org.openapitools.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerMapper mapper;
    @Autowired
    private CustomerService service;

    @Override
    public ResponseEntity createCustomer(Customer customer) {
        try {
            return new ResponseEntity<>(
                    service.createNewCustomer(mapper.map(customer)),
                    HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity getCustomerById(Integer id) {
        try {
            return new ResponseEntity<>(
                    mapper.map(service.findCustomerById(id)),
                    HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(
                    e.getEntityName(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
