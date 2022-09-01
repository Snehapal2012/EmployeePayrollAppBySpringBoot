package com.example.employeepayrollapp.dto;

import com.example.employeepayrollapp.model.PayrollModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object object;

    public ResponseDTO(String message, PayrollModel payrollModel) {
        this.message=message;
        this.object=payrollModel;
    }
    public ResponseDTO(String message, String object) {
        this.message=message;
        this.object=object;
    }

    public ResponseDTO(String message, List<PayrollModel> modelList) {
        this.message=message;
        this.object=modelList;
    }

    public ResponseDTO(String message, Optional<PayrollModel> response) {
        this.message=message;
        this.object=response;
    }

}
