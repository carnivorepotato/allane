package org.allane.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String vin;
    @Column
    @Nonnull
    private String brand;
    @Column
    @Nonnull
    private String model;
    @Column(name = "PRODUCTION_YEAR")
    @Nonnull
    private String productionYear;
    @Column
    @Nonnull
    private Double price;
    @OneToOne(mappedBy = "vehicle")
    private Contract contract;
}
