package com.ust.employeeapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.employeeapp.entities.Courses;
import com.ust.employeeapp.entities.DeletedEmployee;
import com.ust.employeeapp.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeJpaRepo employeeRepository;
	
	@Autowired
	CourseJpaRepo courseRepository;
	
	@Autowired
	EmployeeDeletedJpaRepo employeeDeletedRepository;

	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
		
	}

	public void addEmployee(Employee input) {
		 employeeRepository.save(input);
	}
	
	public List<Courses> fetchAllCourses() {
		return courseRepository.findAll();	
	}

	public void addCourses(Courses input) {
		 courseRepository.save(input);
	}
	
	public boolean findByName(String name) {
		Employee emp = employeeRepository.findByName(name);
		System.out.println(emp);
		if(emp==null){
			return false;
		}
		return true;
	}
	
	public Employee findEmployeeById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		return null;
	}

	public void deleteEmployee(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		DeletedEmployee ed = new DeletedEmployee(emp.get().getId(),emp.get().getName(),emp.get().getSalary());
		employeeDeletedRepository.save(ed);
		employeeRepository.deleteById(id);
		
	}
	
	public Courses findCoursesById(int id) {
		Optional<Courses> cou = courseRepository.findById(id);
		if(cou.isPresent())
		{
			return cou.get();
		}
		return null;
	}

	public void deleteCourses(int id) {
		courseRepository.deleteById(id);
		
	}
	
	public List<DeletedEmployee> fetchAllDeletedEmployee() {
		return employeeDeletedRepository.findAll();
		
	}
	public List<Courses> fetchEmployeeAllCourses(int id){
		
		return courseRepository.findAll().stream().filter((c) -> c.employeeId == id).collect(Collectors.toList());	
	}

}
