package com.gl.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emps")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private int id;
	
	@Column(name="first_name")
	private String fname;
	
	private int salary;
	
	@Column(name="department_id")
	private int departmentId;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}	

	public Employee(int id, String fname, int salary, int departmentId) {
		this.id = id;
		this.fname = fname;
		this.salary = salary;
		this.departmentId = departmentId;
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
	public int hashCode() {
		return Objects.hash(departmentId, fname, id, salary);
	}

	@Override
	public boolean equals(Object obj) {
		Employee other = (Employee) obj;
		return departmentId == other.departmentId && Objects.equals(fname, other.fname) && id == other.id
				&& salary == other.salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", salary=" + salary + ", departmentId=" + departmentId
				+ "]\n";
	}
	
	

}
