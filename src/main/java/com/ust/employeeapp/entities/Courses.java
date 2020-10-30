package com.ust.employeeapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String courseName;
	public boolean courseEnrolled;
	public Date enrollDate;
	public Double price;
	public int employeeId;
	
	public Courses() {
		super();
	}

	public Courses(int id, String courseName,boolean courseEnrolled,Date enrollDate,Double price,int employeeId) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseEnrolled = courseEnrolled;
		this.enrollDate = enrollDate;
		this.price = price;
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean isCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(boolean courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	
}
