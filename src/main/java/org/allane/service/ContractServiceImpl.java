package org.allane.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.allane.database.dao.ContractDao;
import org.allane.model.Contract;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    public final ContractDao contractDao;

    @Override
    public Integer createNewContract(Contract contract) {
        return contractDao.createNewContract(contract);
    }

    @Override
    public Contract findContractByNumber(Integer number) {
        try {
            return contractDao.getContractByNumber(number);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("Could not find contract with number:" + number, number);
        }
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractDao.getAllContracts();
    }
}
