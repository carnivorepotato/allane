package org.allane.database.dao;

import org.allane.database.repository.BrandRepository;
import org.allane.database.repository.ContractRepository;
import org.allane.database.repository.CustomerRepository;
import org.allane.database.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
class DaoFactory {

    private ContractRepository contractRepository;
    private CustomerRepository customerRepository;
    private VehicleRepository vehicleRepository;
    private BrandRepository brandRepository;
    private Logger logger;

    @Bean
    public CommandLineRunner initDatabase(
            ContractRepository contractRepository,
            CustomerRepository customerRepository,
            VehicleRepository vehicleRepository,
            BrandRepository brandRepository) {
        return args -> {
            this.contractRepository = contractRepository;
            this.customerRepository = customerRepository;
            this.vehicleRepository = vehicleRepository;
            this.brandRepository = brandRepository;
            this.logger = LoggerFactory.getLogger(DaoFactory.class);
        };
    }

    public ContractRepository getContractRepository() {
        return contractRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public BrandRepository getBrandRepository() {
        return brandRepository;
    }
}

