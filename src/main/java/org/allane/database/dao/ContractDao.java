package org.allane.database.dao;

import org.allane.model.Contract;

import java.util.List;

public interface ContractDao {

    /**
     * Returns all created contracts
     * @return List of contracts
     */
    List<Contract> getAllContracts();

    /**
     * Returns contract with given contract number
     * @param number Contract number
     * @return Contract with given number
     */
    Contract getContractByNumber(Integer number);

    /**
     * Creates a new contract
     * @param contract Contract details
     * @return New contract number
     */
    Integer createNewContract(Contract contract);
}
