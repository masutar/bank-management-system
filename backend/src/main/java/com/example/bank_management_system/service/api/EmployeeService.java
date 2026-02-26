package com.example.bank_management_system.service.api;

import com.example.bank_management_system.dataAccess.model.EmployeeEntity;
import com.example.bank_management_system.service.model.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeEntity saveEmployee(EmployeeDto employeeDto);
}
