package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dto.EmployeeDTO;
import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@RestController
@RequestMapping("/employeeAPI")
public class EmployeeController {
	
	@Autowired EmployeeService service;
	
	@GetMapping("/employees")
	public List<EmployeeDTO> getEmployees()
	{
		return service.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<String> getEmployeeDetails(@PathVariable("id")Integer id)
	{
		EmployeeDTO emp=null;
	  try {
			emp=service.getEmployeeDetails(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Employee Details are : "+emp);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Employee with "+id+" does not exists.");// Prints on server console
		}		 
	}
}
