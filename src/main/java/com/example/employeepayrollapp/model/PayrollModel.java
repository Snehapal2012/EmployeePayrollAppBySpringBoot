package com.example.employeepayrollapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity

public class PayrollModel {
@Id
@Column
    private int id;
    private String name;
    private String profilePic;
    private String gender;
    private String department;
    private long salary;
    private String notes;
    private LocalDate startDate;

    public int getId(){
    return id;
    }

    public void setId(int id){
    this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getProfilePic(){
        return profilePic;
    }
    public void setProfilePic(String profilePic){
        this.profilePic=profilePic;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public long getSalary(){
        return salary;
    }
    public void setSalary(long salary){
        this.salary=salary;
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes=notes;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate=startDate;
    }

}
