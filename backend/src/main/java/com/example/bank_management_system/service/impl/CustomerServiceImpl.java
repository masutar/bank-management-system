package com.example.bank_management_system.service.impl;

import com.example.bank_management_system.dataAccess.model.AccountEntity;
import com.example.bank_management_system.dataAccess.model.BankEntity;
import com.example.bank_management_system.dataAccess.model.CustomerEntity;
import com.example.bank_management_system.dataAccess.repository.AccountRepository;
import com.example.bank_management_system.dataAccess.repository.BankRepository;
import com.example.bank_management_system.dataAccess.repository.CustomerRepository;
import com.example.bank_management_system.service.api.CustomerService;
import com.example.bank_management_system.service.model.AccountDto;
import com.example.bank_management_system.service.model.CustomerDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BankRepository bankRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private static final String CLASS_NAME = CustomerServiceImpl.class.getName();

    @Override
    public void saveCustomer(CustomerDto customerDto, String branchName) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "saveCustomer");
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setDob(customerDto.getDob());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setContactNumber(customerDto.getContactNumber());
        customerEntity.setNomineeName(customerDto.getNomineeName());
        customerEntity.setGender(customerDto.getGender());
        customerRepository.save(customerEntity);
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountHolderName(customerDto.getFirstName() + " " + customerDto.getLastName());
        accountDto.setCustomerId(customerEntity.getCustomerId());
        accountDto.setNomineeName(customerDto.getNomineeName());
        BankEntity bankEntity = bankRepository.findByBranchName(branchName);
        accountDto.setBankId(bankEntity.getId());
        accountDto.setIFFCCode(bankEntity.getIFFCCode());
        saveAccountDetails(accountDto);
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "saveCustomer");
    }

    private void saveAccountDetails(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCustomerId(accountDto.getCustomerId());
        accountEntity.setAccountHolderName(accountDto.getAccountHolderName());
        accountEntity.setNomineeName(accountDto.getNomineeName());
        accountEntity.setIFFCCode(accountDto.getIFFCCode());
        accountEntity.setBankId(accountDto.getBankId());
        accountRepository.save(accountEntity);
    }
}
