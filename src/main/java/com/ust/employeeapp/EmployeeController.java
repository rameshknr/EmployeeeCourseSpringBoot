package com.ust.employeeapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.employeeapp.entities.Courses;
import com.ust.employeeapp.entities.DeletedEmployee;
import com.ust.employeeapp.entities.Employee;
import com.ust.employeeapp.services.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	

	@GetMapping("/")
	public List<Employee> fetchAllEmployee(){
		return employeeService.fetchAllEmployees();
	}	
	@PostMapping("/")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
		if(employeeService.findByName(employee.name)){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		 employeeService.addEmployee(employee);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/courses")
	public List<Courses> fetchAllCourses(){
		return employeeService.fetchAllCourses();
	}	
	@PostMapping("/courses")
	public ResponseEntity<Void> addCourses(@RequestBody Courses courses){	
		 employeeService.addCourses(courses);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}/courses")
	public List<Courses> fetchEmployeeAllCourses(@PathVariable("id")int id){
		return employeeService.fetchEmployeeAllCourses(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable("id")int id){
		System.out.println("In Fetch employee: " + id);
		ResponseEntity<Employee> re = null; 
		Employee employee = employeeService.findEmployeeById(id);
		if(employee==null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return re;
		
		
	}
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		
		ResponseEntity<String> re = null;
		try{
			employeeService.deleteEmployee(id);
			re = ResponseEntity.ok().body("employee has been deleted successfully.");
		}
		catch(EmptyResultDataAccessException e){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Courses> fetchCourse(@PathVariable("id")int id){
		System.out.println("In Fetch course: " + id);
		ResponseEntity<Courses> re = null; 
		Courses courses = employeeService.findCoursesById(id);
		if(courses==null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(courses, HttpStatus.OK);
		}
		return re;
		
		
	}
	@RequestMapping(path="/courses/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<String> deleteCourse(@PathVariable("id") int id){
		
		ResponseEntity<String> re = null;
		try{
			employeeService.deleteCourses(id);
			re = ResponseEntity.ok().body("Course has been deleted successfully.");
		}
		catch(EmptyResultDataAccessException e){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	@GetMapping("/deleted-employee")
	public List<DeletedEmployee> fetchAllDeletedEmployee(){
		return employeeService.fetchAllDeletedEmployee();
	}

}
