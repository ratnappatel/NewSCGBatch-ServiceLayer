package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dto.EmployeeDTO;
import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@RestController
@RequestMapping("/employeeAPI")
@CrossOrigin
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
			e.printStackTrace(); // sends exception details to server console
			return ResponseEntity.badRequest().body("Employee with "+id+" does not exists.");// Prints on server console
			// return statement sends exception details to client[?]
		}		 
	}


	@PostMapping("/employees")
	public Employee addNewEmployee(@RequestBody Employee emp)
	{
		Employee added=service.addEmployee(emp);
		return added;
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployee(@PathVariable("id")Integer id,@RequestBody Employee e)
	{
		String res=service.updateEmployeeDetails(id, e);
		if(res.equalsIgnoreCase("success"))
			return "Employee Details updated Successfully..";
		else
			return "Employeed Couldn't updated...";
	}
	
	@DeleteMapping("/employees/{id}")
	public String removeEmployee(@PathVariable("id")Integer id)
	{
		String res=service.removeEmployeeDetails(id);
		if(res.equalsIgnoreCase("success"))
			return "Employee Details removed Successfully..";
		else
			return "Employee Details couldn't remove";
	}
	
}
