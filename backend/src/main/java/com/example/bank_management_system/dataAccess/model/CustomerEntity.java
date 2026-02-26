package com.example.bank_management_system.dataAccess.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;

    @Column(nullable = false) // Ensures the column is not null
    private String firstName;

    @Column(nullable = false) // Ensures the column is not null
    private String lastName;

    @Column(nullable = false) // Ensures the column is not null
    private LocalDate dob;

    @Column(nullable = false) // Ensures the column is not null
    private String email;

    @Column(nullable = false) // Ensures the column is not null
    private String contactNumber;

    @Column(nullable = false) // Ensures the column is not null
    private String gender;

    @Column(nullable = false) // Ensures the column is not null
    private String nomineeName;
}

