package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.PayrollModel;
import com.example.employeepayrollapp.repository.PayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
    @Autowired
    PayrollRepo repo;
    public String greetEmp(String name) {
        return "<h1><font color=orange style=bold>Hello "+name+" ! Welcome to Employee Payroll App! </font></h1>";
    }

    public String upload(PayrollModel model) {
        repo.save(model);
        String list="id: "+model.getId()+" Name: "+model.getName()+"  Profile pic: "+model.getProfilePic()+"  Gender: "+model.getGender()+"  Department: "+model.getDepartment()+"  Salary: "+model.getSalary()+"  Notes: "+model.getNotes()+"  Start date: "+model.getStartDate();
        return list;
    }

    public List<PayrollModel> getAll() {
        List<PayrollModel> list=repo.findAll();
        return list;
    }

    public PayrollModel edit(PayrollModel entity, int id) {
        PayrollModel model=repo.findById(id).get();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setProfilePic(entity.getProfilePic());
        model.setGender(entity.getGender());
        model.setDepartment(entity.getDepartment());
        model.setSalary(entity.getSalary());
        model.setNotes(entity.getNotes());
        model.setStartDate(entity.getStartDate());
        return repo.save(model);
    }
}
