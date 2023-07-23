package org.allane.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "LEASING_CONTRACT")
public class Contract {
    @Id
    @Column(name = "contract_number")
    private Integer contractNumber;
    @Column(name = "monthly_rate")
    @Nonnull
    private Double monthlyRate;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;
}
