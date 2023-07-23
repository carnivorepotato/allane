package org.allane.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "first_name")
    @Nonnull
    private String firstName;
    @Column(name = "last_name")
    @Nonnull
    private String lastName;
    @Column(name = "birth_date")
    @Nonnull
    private String birthDate;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
