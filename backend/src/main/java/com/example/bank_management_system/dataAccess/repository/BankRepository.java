package com.example.bank_management_system.dataAccess.repository;

import com.example.bank_management_system.dataAccess.model.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, UUID> {
    @Query(value = "select * from bank where branch =:branchName", nativeQuery = true)
    BankEntity findByBranchName(@Param("branchName") String branchName);
}
