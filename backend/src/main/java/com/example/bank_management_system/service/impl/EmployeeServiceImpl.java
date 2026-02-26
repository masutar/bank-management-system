package com.example.bank_management_system.service.impl;

import com.example.bank_management_system.dataAccess.model.EmployeeEntity;
import com.example.bank_management_system.dataAccess.repository.EmployeeRepository;
import com.example.bank_management_system.service.api.EmployeeService;
import com.example.bank_management_system.service.model.EmployeeDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private static final String CLASS_NAME = EmployeeServiceImpl.class.getName();

    @Override
    public EmployeeEntity saveEmployee(EmployeeDto employeeDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "saveEmployee");
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setDob(employeeDto.getDob());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setGender(employeeDto.getGender());
        employeeEntity.setContactNumber(employeeDto.getContactNumber());
        employeeRepository.save(employeeEntity);
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "saveEmployee");
        return employeeEntity;
    }
}
