package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.PayrollModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepo extends JpaRepository<PayrollModel, Integer> {
}
