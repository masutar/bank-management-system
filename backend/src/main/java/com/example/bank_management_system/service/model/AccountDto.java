package com.example.bank_management_system.service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountDto {
    private UUID customerId;
    private String accountHolderName;
    private String nomineeName;
    private String IFFCCode;
    private UUID bankId;
}
