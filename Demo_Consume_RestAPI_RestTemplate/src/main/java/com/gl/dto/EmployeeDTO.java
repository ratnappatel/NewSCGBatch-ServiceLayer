package com.gl.dto;

public class EmployeeDTO {
	
	private int id;
	private String fname;
	private int salary;
	private int departmentId;
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", fname=" + fname + ", salary=" + salary + ", departmentId=" + departmentId
				+ "]";
	}
	

}
