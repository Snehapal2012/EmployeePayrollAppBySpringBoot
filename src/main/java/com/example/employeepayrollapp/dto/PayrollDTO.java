package com.example.employeepayrollapp.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PayrollDTO {
    private String name;
    private String profilePic;
    private String gender;
    private String department;
    private long salary;
    private String notes;
    private LocalDate startDate;
}
