package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.PayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.PayrollModel;
import com.example.employeepayrollapp.repository.PayrollRepo;
import com.example.employeepayrollapp.service.IPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PayrollController {
    @Autowired
    IPayrollService service;
    @Autowired
    PayrollRepo repo;
    //to display welcome message
    @GetMapping(value = {"","/","/home"})
    public String home(){
        return "<h1><font color=blue style=bold>Welcome to Employee Payroll App !!</font></h1>";
    }
    //to greet any particular employee by their name
    @GetMapping("/greetEmployee/{name}")
    public String greetEmp(@PathVariable String name){
        String result=service.greetEmp(name);
        return result;
    }
    //to find any particular employee details using id
    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<ResponseDTO> findId(@PathVariable long id){
        Optional<PayrollModel> response=service.findById(id);
        ResponseDTO responseDTO=new ResponseDTO("Employee details is found!",response);
        return new ResponseEntity(responseDTO,HttpStatus.FOUND);
    }
    @GetMapping("/getDepartment/{department}")
    public ResponseEntity<ResponseDTO> getDepartment(@PathVariable String department){
        List<PayrollModel> list=service.findEmployeesByDepartment(department);
        ResponseDTO responseDTO=new ResponseDTO("Employee department is found!",list);
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }

    //to upload or add any new employee details
    @PostMapping("/upload")
    public ResponseEntity<ResponseDTO> upload(@Valid @RequestBody PayrollDTO model){
        PayrollModel payrollModel=service.upload(model);
        ResponseDTO responseDTO=new ResponseDTO("Employee details uploaded successfully!",payrollModel);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
    //to get all employee details
    @GetMapping("/allDetails")
    public ResponseEntity<ResponseDTO> getAll(){
        List<PayrollModel> modelList=service.getAll();
        ResponseDTO responseDTO=new ResponseDTO("All Employee details!",modelList);
        return new ResponseEntity(responseDTO,HttpStatus.OK);
    }
    //to get any employee details using put method
    @PutMapping("/put/{id}")
    public String put(@Valid @PathVariable long id,@RequestParam(value = "name") String name,
                      @RequestParam(value = "profilePic") String profilePic, @RequestParam(value = "gender") String gender, @RequestParam(value = "department") String department,  @RequestParam(value = "notes") String notes) {
        return "<h1><font color=brown style=bold>Details:-- " +"Name: "+name +" Profile Pic: " + profilePic + "  Gender: "+gender+"  Department: "+department+"  Notes: </font></h1>"+notes;
    }
    //edit any employee details by id
    @PutMapping("/editEmployee/{id}")
    public ResponseEntity<ResponseDTO> edit(@Valid @RequestBody PayrollDTO entity,@PathVariable long id) {
        PayrollModel payrollModel= service.edit(entity,id);
        ResponseDTO responseDTO=new ResponseDTO("Employee details is edited!",payrollModel);
        return new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);
    }
    //delete any employee details by id
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable long id) {
        service.delete(id);
        ResponseDTO responseDTO=new ResponseDTO("Employee details is deleted!","Deleted employee id: "+id);
        return new ResponseEntity(responseDTO,HttpStatus.GONE);
    }

}
