package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.PayrollDTO;
import com.example.employeepayrollapp.model.PayrollModel;


import java.util.List;
import java.util.Optional;

public interface IPayrollService {
    String greetEmp(String name);
    PayrollModel upload(PayrollDTO model);
    PayrollModel edit(PayrollDTO entity, long id);

    List<PayrollModel> findEmployeesByDepartment(String department);
    List<PayrollModel> getAll();
    Optional<PayrollModel> findById(long id);
    void delete(long id);
}
