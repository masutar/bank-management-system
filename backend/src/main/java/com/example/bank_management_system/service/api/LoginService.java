package com.example.bank_management_system.service.api;

import com.example.bank_management_system.service.model.LoginDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    boolean loggedIn(LoginDto loginDto);
}
