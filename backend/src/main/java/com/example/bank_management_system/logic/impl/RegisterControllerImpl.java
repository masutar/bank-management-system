package com.example.bank_management_system.logic.impl;

import com.example.bank_management_system.logic.api.RegisterController;
import com.example.bank_management_system.logic.model.RegisterDto;
import com.example.bank_management_system.logic.model.ResponseDto;
import com.example.bank_management_system.service.api.RegisterService;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterControllerImpl implements RegisterController {
    @Autowired
    RegisterService registerService;
    private static final Logger logger = LoggerFactory.getLogger(RegisterControllerImpl.class);
    private static final String CLASS_NAME = RegisterControllerImpl.class.getName();

    @Override
    public ResponseDto register(RegisterDto registerDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "register");
        ResponseDto responseDto = new ResponseDto();
        if (registerService.register(registerDto)) {
            responseDto.setCode(HttpStatus.OK.value());
            responseDto.setStatus(HttpStatus.OK.name());
            responseDto.setMessage("Registered Successfully");
        } else {
            responseDto.setCode(HttpStatus.NOT_FOUND.value());
            responseDto.setStatus(HttpStatus.NOT_FOUND.name());
            responseDto.setMessage("Please enter valid id");
        }
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "register");
        return responseDto;
    }
}
