package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.PayrollModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PayrollRepo extends JpaRepository<PayrollModel, Long> {
    @Query(value = "select * from payroll_service.payroll_department,payroll_service.payroll_model where payroll_model.employee_id=payroll_department.id and department= :department",nativeQuery = true)
    List<PayrollModel> findEmployeesByDepartment(String department);
}
