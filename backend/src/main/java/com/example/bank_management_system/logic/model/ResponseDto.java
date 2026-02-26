package com.example.bank_management_system.logic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    int code;
    String status;
    String message;
}
