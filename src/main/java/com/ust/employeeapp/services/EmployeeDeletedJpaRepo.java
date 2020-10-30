package com.ust.employeeapp.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.employeeapp.entities.DeletedEmployee;

public interface EmployeeDeletedJpaRepo extends JpaRepository<DeletedEmployee, Integer>{
}
