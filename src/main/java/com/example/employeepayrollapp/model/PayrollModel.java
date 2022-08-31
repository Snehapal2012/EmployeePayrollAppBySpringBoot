package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.PayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class PayrollModel {
@Id
@Column
@GeneratedValue
    private int id;
    private String name;
    private String profilePic;
    private String gender;
    private String department;
    private long salary;
    private String notes;
    private Date startDate;
    public PayrollModel(PayrollDTO model) {
        this.name=model.getName();
        this.profilePic=model.getProfilePic();
        this.gender=model.getGender();
        this.department=model.getDepartment();
        this.salary= model.getSalary();
        this.notes=model.getNotes();
        this.startDate=model.getStartDate();
    }

}
