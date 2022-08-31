package com.example.employeepayrollapp.dto;

import com.example.employeepayrollapp.model.PayrollModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object object;

    public ResponseDTO(String message, PayrollModel payrollModel) {
        this.message=message;
        this.object=payrollModel;
    }
}
