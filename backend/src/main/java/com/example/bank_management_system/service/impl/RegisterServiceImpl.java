package com.example.bank_management_system.service.impl;

import com.example.bank_management_system.dataAccess.model.CustomerEntity;
import com.example.bank_management_system.dataAccess.model.EmployeeEntity;
import com.example.bank_management_system.dataAccess.model.LoginEntity;
import com.example.bank_management_system.dataAccess.repository.CustomerRepository;
import com.example.bank_management_system.dataAccess.repository.EmployeeRepository;
import com.example.bank_management_system.dataAccess.repository.LoginRepository;
import com.example.bank_management_system.logic.model.RegisterDto;
import com.example.bank_management_system.service.api.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean register(RegisterDto registerDto) {
        String id = registerDto.getId();
        Optional<EmployeeEntity> employee = employeeRepository.findById(UUID.fromString(id));
        Optional<CustomerEntity> customer = customerRepository.findById(UUID.fromString(id));
        LoginEntity loginEntity = new LoginEntity();
        if (employee.isPresent() || customer.isPresent()) {
            loginEntity.setUsername(registerDto.getUsername());
            loginEntity.setPassword(registerDto.getPassword());
            loginRepository.save(loginEntity);
            return true;
        }
        return false;
    }
}
