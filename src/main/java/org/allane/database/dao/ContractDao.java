package org.allane.database.dao;

import org.allane.model.Contract;

import java.util.List;

public interface ContractDao {

    List<Contract> getAllContracts();

    Contract getContractByNumber(Integer number);

    Integer createNewContract(Contract contract);
}
