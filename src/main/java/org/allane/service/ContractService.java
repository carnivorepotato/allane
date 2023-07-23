package org.allane.service;

import org.allane.model.Contract;

import java.util.List;

public interface ContractService {
    /**
     *
     * @param contract
     * @return
     * @throws IllegalArgumentException Contract with this id already exists.
     */
    Integer createNewContract(Contract contract);

    /**
     *
     * @param number
     * @return
     */
    Contract findContractByNumber(Integer number);

    /**
     *
     * @return
     */
    List<Contract> getAllContracts();
}
