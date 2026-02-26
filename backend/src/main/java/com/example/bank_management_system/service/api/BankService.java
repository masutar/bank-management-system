package com.example.bank_management_system.service.api;

import com.example.bank_management_system.service.model.BankDto;
import org.springframework.stereotype.Service;

@Service
public interface BankService {
    void saveBankDetails(BankDto bankDto);
}
