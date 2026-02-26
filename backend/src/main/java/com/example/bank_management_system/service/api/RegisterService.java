package com.example.bank_management_system.service.api;

import com.example.bank_management_system.logic.model.RegisterDto;
import com.example.bank_management_system.logic.model.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    boolean register(RegisterDto registerDto);
}
