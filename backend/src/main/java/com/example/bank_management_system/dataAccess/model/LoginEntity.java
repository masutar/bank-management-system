package com.example.bank_management_system.dataAccess.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false) // Ensures the column is not null
    private String username;

    @Column(nullable = false) // Ensures the column is not null
    private String password;
}
