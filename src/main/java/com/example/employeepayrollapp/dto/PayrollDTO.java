package com.example.employeepayrollapp.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class PayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}\\s{0,}[A-z]{1}[a-z]{2,}",message = "Invalid Employee name!")
    private String name;
    @NotEmpty(message = "Profile pic is empty!")
    private String profilePic;
    @NotNull(message = "Gender should not be null!")
    private String gender;
    private List<String> department;
    @Min(value = 10000,message = "Salary should be more than 10,000!")
    private long salary;
    @Size(min=2,message = "Notes length should be more than 2!")
    private String notes;
    @Past(message = "Start date should be in past!")
    private LocalDate startDate;
}
