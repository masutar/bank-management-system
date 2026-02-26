package com.example.bank_management_system.logic.impl;

import com.example.bank_management_system.logic.api.LoginController;
import com.example.bank_management_system.logic.model.ResponseDto;
import com.example.bank_management_system.service.api.LoginService;
import com.example.bank_management_system.service.model.LoginDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerImpl implements LoginController {

    @Autowired
    LoginService loginService;
    private static final Logger logger = LoggerFactory.getLogger(LoginControllerImpl.class);
    private static final String CLASS_NAME = LoginControllerImpl.class.getName();

    @Override
    public ResponseDto loggedIn(LoginDto loginDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "loggedIn");
        ResponseDto response = new ResponseDto();
        if (loginService.loggedIn(loginDto)) {
            response.setCode(HttpStatus.OK.value());
            response.setStatus(HttpStatus.OK.name());
            response.setMessage("Logged In Successfully");
        } else {
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setStatus(HttpStatus.UNAUTHORIZED.name());
            response.setMessage("Logged In Failed");
        }
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "loggedIn");
        return response;
    }
}
