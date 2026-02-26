package com.example.bank_management_system.logic.impl;

import com.example.bank_management_system.logic.api.CustomerController;
import com.example.bank_management_system.logic.model.CustomerResponseDto;
import com.example.bank_management_system.service.api.CustomerService;
import com.example.bank_management_system.service.model.CustomerDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerImpl implements CustomerController {
    @Autowired
    CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerImpl.class);
    private static final String CLASS_NAME = CustomerControllerImpl.class.getName();

    @Override
    public CustomerResponseDto saveCustomer(CustomerDto customerDto, String branchName) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "saveCustomer");
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerService.saveCustomer(customerDto, branchName);
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "saveCustomer");
        return customerResponseDto;
    }
}
