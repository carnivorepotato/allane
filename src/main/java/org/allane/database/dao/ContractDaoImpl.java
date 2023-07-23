package org.allane.database.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.allane.model.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractDaoImpl implements ContractDao {

    @NonNull
    private DaoFactory daoFactory;

    @Override
    public List<Contract> getAllContracts() {
        return daoFactory.getContractRepository().findAll();
    }

    @Override
    public Contract getContractByNumber(Integer number) {
        return daoFactory.getContractRepository().getReferenceById(number);
    }

    @Override
    public Integer createNewContract(Contract contract) {
        return daoFactory.getContractRepository().save(contract).getContractNumber();
    }
}
