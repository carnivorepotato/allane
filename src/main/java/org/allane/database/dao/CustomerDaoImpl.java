package org.allane.database.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.allane.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {

    @NonNull
    private DaoFactory daoFactory;

    @Override
    public Integer createNewCustomer(Customer customer) {
        return daoFactory.getCustomerRepository().save(customer).getId();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return daoFactory.getCustomerRepository().getReferenceById(id);
    }
}
