package com.example.bank_management_system.service.impl;

import com.example.bank_management_system.dataAccess.model.LoginEntity;
import com.example.bank_management_system.dataAccess.repository.LoginRepository;
import com.example.bank_management_system.service.api.LoginService;
import com.example.bank_management_system.service.model.LoginDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginRepository;
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private static final String CLASS_NAME = LoginServiceImpl.class.getName();

    @Override
    public boolean loggedIn(LoginDto loginDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "loggedIn");
        LoginEntity entity = loginRepository.findByUsername(loginDto.getUsername());
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "loggedIn");
        if (entity.getPassword().equals(loginDto.getPassword())) {
            logger.info("Logged In Successfully");
            return true;
        } else {
            logger.error("Logged In Failed. Please check username or password");
            return false;
        }
    }
}
