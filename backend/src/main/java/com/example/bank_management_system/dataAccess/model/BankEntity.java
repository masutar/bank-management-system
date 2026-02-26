package com.example.bank_management_system.dataAccess.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "bank")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false) // Ensures the column is not null
    private String bankName;
    @Column(nullable = false) // Ensures the column is not null
    private String IFFCCode;
    @Column(nullable = false) // Ensures the column is not null
    private String email;
    @Column(nullable = false) // Ensures the column is not null
    private String branch;
}
