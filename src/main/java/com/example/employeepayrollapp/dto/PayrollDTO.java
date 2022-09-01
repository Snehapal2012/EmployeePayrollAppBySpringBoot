package com.example.employeepayrollapp.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}\\s{0,}[A-z]{1}[a-z]{2,}",message = "Invalid Employee name!")
    private String name;
    @NotEmpty
    private String profilePic;
    @NotNull
    private String gender;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}",message = "Invalid Department")
    private String department;
    @Min(value = 10000)
    private long salary;
    @Size(min=2)
    private String notes;
    @Past
    private LocalDate startDate;
}
