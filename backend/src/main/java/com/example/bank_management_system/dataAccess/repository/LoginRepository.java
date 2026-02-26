package com.example.bank_management_system.dataAccess.repository;

import com.example.bank_management_system.dataAccess.model.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, UUID> {
    LoginEntity findByUsername(String username);
}
