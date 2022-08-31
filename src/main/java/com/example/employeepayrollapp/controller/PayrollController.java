package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.PayrollDTO;
import com.example.employeepayrollapp.model.PayrollModel;
import com.example.employeepayrollapp.repository.PayrollRepo;
import com.example.employeepayrollapp.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PayrollController {
    @Autowired
    PayrollService service;
    @Autowired
    PayrollRepo repo;
    @GetMapping(value = {"","/","/home"})
    public String home(){
        return "<h1><font color=blue style=bold>Welcome to Employee Payroll App !!</font></h1>";
    }
    @GetMapping("/greetEmp/{name}")
    public String greetEmp(@PathVariable String name){
        String result=service.greetEmp(name);
        return result;
    }
    @PostMapping("/upload")
    public PayrollModel upload(@RequestBody PayrollDTO model){
        PayrollModel payrollModel=service.upload(model);
        return payrollModel;
    }
    @GetMapping("/allDetails")
    public List<PayrollModel> getAll(){
        List<PayrollModel> modelList=service.getAll();
        return modelList;
    }
    @PutMapping("/put/{id}")
    public String put(@PathVariable int id,@RequestParam(value = "name") String name,
                      @RequestParam(value = "profilePic") String profilePic, @RequestParam(value = "gender") String gender, @RequestParam(value = "department") String department,  @RequestParam(value = "notes") String notes) {
        return "<h1><font color=brown style=bold>Details:-- " +"Name: "+name +" Profile Pic: " + profilePic + "  Gender: "+gender+"  Department: "+department+"  Notes: </font></h1>"+notes;
    }
    @PutMapping("/editEmp/{id}")
    public PayrollModel edit(@RequestBody PayrollDTO entity,@PathVariable int id) {
        PayrollModel payrollModel= service.edit(entity,id);
        return payrollModel;
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted!";
    }

}
