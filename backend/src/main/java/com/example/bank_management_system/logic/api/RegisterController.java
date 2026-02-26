package com.example.bank_management_system.logic.api;

import com.example.bank_management_system.logic.model.RegisterDto;
import com.example.bank_management_system.logic.model.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backend")
public interface RegisterController {
    @PostMapping("/register")
    ResponseDto register(@RequestBody RegisterDto registerDto);
}
