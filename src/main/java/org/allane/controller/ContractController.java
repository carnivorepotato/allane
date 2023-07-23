package org.allane.controller;

import org.allane.mapper.ContractMapper;
import org.allane.service.ContractService;
import org.hibernate.ObjectNotFoundException;
import org.openapitools.api.ContractApi;
import org.openapitools.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractController implements ContractApi {

    @Autowired
    private ContractMapper mapper;
    @Autowired
    private ContractService service;

    @Override
    public ResponseEntity<Integer> createContract(Contract contract) {
        return new ResponseEntity<>(
                service.createNewContract(mapper.map(contract)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Contract>> getAllContracts() {
        return new ResponseEntity<>(
                mapper.map(service.getAllContracts()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity getContractByNumber(Integer contractNumber) {
        try {
            return new ResponseEntity<>(
                    mapper.map(service.findContractByNumber(contractNumber)),
                    HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(
                    e.getEntityName(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
