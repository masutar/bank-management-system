package com.example.bank_management_system.logic.api;

import com.example.bank_management_system.logic.model.CustomerResponseDto;
import com.example.bank_management_system.service.model.CustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backend")
public interface CustomerController {
    @PostMapping("/customer/{branchName}")
    CustomerResponseDto saveCustomer(@RequestBody CustomerDto customerDto, @PathVariable String branchName);
}
