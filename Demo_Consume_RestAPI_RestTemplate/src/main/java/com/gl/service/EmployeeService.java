package com.gl.service;

import java.util.List;

import com.gl.dto.EmployeeDTO;
import com.gl.entity.Employee;

public interface EmployeeService {
	public EmployeeDTO getEmployeeDetails(int id)throws Exception;
	public List<EmployeeDTO> getAllEmployees();
	public Employee addEmployee(Employee e);
	public String updateEmployeeDetails(int id, Employee e);
	public String removeEmployeeDetails(int id);
}
