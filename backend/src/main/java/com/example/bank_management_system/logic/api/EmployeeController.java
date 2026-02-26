package com.example.bank_management_system.logic.api;

import com.example.bank_management_system.logic.model.EmployeeResponseDto;
import com.example.bank_management_system.service.model.EmployeeDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backend")
public interface EmployeeController {
    @PostMapping("/employee")
    EmployeeResponseDto saveEmployee(@RequestBody EmployeeDto employeeDto);
}
