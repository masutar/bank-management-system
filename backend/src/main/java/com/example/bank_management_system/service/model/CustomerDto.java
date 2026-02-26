package com.example.bank_management_system.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDto {
    private String firstName;
    private String lastName;
    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String email;
    private String contactNumber;
    private String gender;
    private String nomineeName;
}
