package com.example.bank_management_system.logic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
    private String message;
    private String status;
    private int code;
    private String username;
    private String employeeId;
}
