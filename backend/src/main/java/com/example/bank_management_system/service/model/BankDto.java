package com.example.bank_management_system.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDto {
    private String bankName;
    private String IFFCCode;
    private String email;
    private String branch;
}
