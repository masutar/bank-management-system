package com.example.bank_management_system.logic.impl;

import com.example.bank_management_system.logic.api.BankController;
import com.example.bank_management_system.logic.model.ResponseDto;
import com.example.bank_management_system.service.api.BankService;
import com.example.bank_management_system.service.model.BankDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankControllerImpl implements BankController {
    @Autowired
    BankService bankService;
    private static final Logger logger = LoggerFactory.getLogger(BankControllerImpl.class);
    private static final String CLASS_NAME = BankControllerImpl.class.getName();

    @Override
    public ResponseDto saveBankDetails(BankDto bankDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "saveBankDetails");
        ResponseDto responseDto = new ResponseDto();
        bankService.saveBankDetails(bankDto);
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "saveBankDetails");
        return responseDto;
    }
}
