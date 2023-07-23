package org.allane.service;

import org.allane.model.Contract;
import org.hibernate.ObjectNotFoundException;

import java.util.List;

public interface ContractService {
    /**
     * Creates new contract
     * @param contract Contract details
     * @return New contract id
     * @throws IllegalArgumentException Contract with this number already exists.
     */
    Integer createNewContract(Contract contract);

    /**
     * Returns contract with given contract number
     * @param number Contract number
     * @return Contract with given number
     * @throws ObjectNotFoundException Could not find contract with given number
     */
    Contract findContractByNumber(Integer number);

    /**
     * Returns all created contracts
     * @return List of contracts
     */
    List<Contract> getAllContracts();
}
