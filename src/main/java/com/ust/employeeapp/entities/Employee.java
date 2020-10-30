package com.ust.employeeapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee implements Comparable<Employee> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String name;
	public Double salary;


	
//	@OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
//	public List<Courses> courses;
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

//	public Employee(int id, String name, double salary,List<Courses> courses) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.salary = salary;
//		this.courses = courses;
//	}

	public int compareTo(Employee o) {
		if (this.id > o.id) {
			return 1;
		} else if (this.id < o.id) {
			return -1;
		} else {
			return 0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

//	public List<Courses> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Courses> courses) {
//		this.courses = courses;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", courses=" + courses + "]";
//	}
	
	

}
