package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.PayrollDTO;
import com.example.employeepayrollapp.model.PayrollModel;
import com.example.employeepayrollapp.repository.PayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    PayrollRepo repo;
    public String greetEmp(String name) {
        return "<h1><font color=orange style=bold>Hello "+name+" ! Welcome to Employee Payroll App! </font></h1>";
    }

    public PayrollModel upload(PayrollDTO model) {
        PayrollModel payrollModel=new PayrollModel(model);
        repo.save(payrollModel);
        return payrollModel;
    }

    public List<PayrollModel> getAll() {
        List<PayrollModel> list=repo.findAll();
        return list;
    }

    public PayrollModel edit(PayrollDTO entity, int id) {
        PayrollModel model=repo.findById(id).get();
        model.setName(entity.getName());
        model.setProfilePic(entity.getProfilePic());
        model.setGender(entity.getGender());
        model.setDepartment(entity.getDepartment());
        model.setSalary(entity.getSalary());
        model.setNotes(entity.getNotes());
        model.setStartDate(entity.getStartDate());
        return repo.save(model);
    }

    public Optional<PayrollModel> findById(int id) {
        return repo.findById(id);
    }
}
