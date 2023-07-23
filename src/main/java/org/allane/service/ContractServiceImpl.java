package org.allane.service;

import lombok.RequiredArgsConstructor;
import org.allane.database.dao.ContractDao;
import org.allane.model.Contract;
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
        return contractDao.getContractByNumber(number);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractDao.getAllContracts();
    }
}
