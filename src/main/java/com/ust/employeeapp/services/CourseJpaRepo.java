package com.ust.employeeapp.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ust.employeeapp.entities.Courses;

public interface CourseJpaRepo extends JpaRepository<Courses, Integer>{
	
	@Query("select c from Courses c")
	public Double findTotalSalary();

}
