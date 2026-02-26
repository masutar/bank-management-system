package com.example.bank_management_system.service.impl;

import com.example.bank_management_system.dataAccess.model.BankEntity;
import com.example.bank_management_system.dataAccess.repository.BankRepository;
import com.example.bank_management_system.service.api.BankService;
import com.example.bank_management_system.service.model.BankDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepository;
    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);
    private static final String CLASS_NAME = BankServiceImpl.class.getName();

    @Override
    public void saveBankDetails(BankDto bankDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "saveBankDetails");
        BankEntity bankEntity = new BankEntity();
        bankEntity.setBankName(bankDto.getBankName());
        bankEntity.setBranch(bankDto.getBranch());
        bankEntity.setEmail(bankDto.getEmail());
        bankEntity.setIFFCCode(bankDto.getIFFCCode());
        bankRepository.save(bankEntity);
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "saveBankDetails");
    }
}
