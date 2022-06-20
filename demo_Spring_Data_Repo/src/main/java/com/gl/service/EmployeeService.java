package com.gl.service;

import java.util.List;

import com.gl.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee getByID(int id);
	public Employee addEmployee(Employee e);
	public Employee updateEmployee(Employee e,int id);
	public String removeEmployee(int id);
	
	public List<Employee> getBySalaryRange(int s1,int s2);
	public Employee employeeByName(String name);
	public List<Employee> employeeSalaryMoreThan(int salary);
}
