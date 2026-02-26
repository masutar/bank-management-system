package com.example.bank_management_system.service.api;

import com.example.bank_management_system.service.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    void saveCustomer(CustomerDto customerDto, String branchName);
}
