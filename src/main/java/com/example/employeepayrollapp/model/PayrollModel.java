package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.PayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "payroll_model")
@Data
@NoArgsConstructor
public class PayrollModel {
@Id
@Column(name = "id")
@GeneratedValue
    private int id;
@Column(name = "name")
    private String name;
    private String profilePic;
    private String gender;
    private long salary;
    private String notes;
    private LocalDate startDate;
    @ElementCollection
    @CollectionTable(name = "payroll_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;
    public PayrollModel(PayrollDTO model) {
        this.name=model.getName();
        this.profilePic=model.getProfilePic();
        this.gender=model.getGender();
        this.departments=model.getDepartments();
        this.salary= model.getSalary();
        this.notes=model.getNotes();
        this.startDate=model.getStartDate();
    }

}
