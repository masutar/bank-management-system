package com.example.bank_management_system.dataAccess.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID accountId;
    @Column(nullable = false) // Ensures the column is not null
    private UUID customerId;
    @Column(nullable = false) // Ensures the column is not null
    private String accountHolderName;
    @Column(nullable = false) // Ensures the column is not null
    private String nomineeName;
    @Column(nullable = false) // Ensures the column is not null
    private String IFFCCode;
    @Column(nullable = false)
    private UUID bankId;

}
