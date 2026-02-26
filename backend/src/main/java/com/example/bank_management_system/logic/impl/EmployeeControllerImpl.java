package com.example.bank_management_system.logic.impl;

import com.example.bank_management_system.dataAccess.model.EmployeeEntity;
import com.example.bank_management_system.logic.api.EmployeeController;
import com.example.bank_management_system.logic.model.EmployeeResponseDto;
import com.example.bank_management_system.service.api.EmployeeService;
import com.example.bank_management_system.service.model.EmployeeDto;
import com.example.bank_management_system.utils.LoggerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerImpl.class);
    private static final String CLASS_NAME = EmployeeControllerImpl.class.getName();

    @Override
    public EmployeeResponseDto saveEmployee(EmployeeDto employeeDto) {
        LoggerHelper.logMethodEntry(logger, CLASS_NAME, "saveEmployee");
        EmployeeEntity employeeEntity = employeeService.saveEmployee(employeeDto);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setEmployeeId(String.valueOf(employeeEntity.getEmployeeId()));
        employeeResponseDto.setCode(HttpStatus.OK.value());
        employeeResponseDto.setMessage("Your details are saved successfully. Please save your employeeId and username");
        employeeResponseDto.setUsername(employeeDto.getEmail());
        employeeResponseDto.setStatus(HttpStatus.OK.name());
        LoggerHelper.logMethodExit(logger, CLASS_NAME, "saveEmployee");
        return employeeResponseDto;
    }
}
