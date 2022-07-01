package com.gl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gl.dto.EmployeeDTO;
import com.gl.entity.Employee;

@SpringBootApplication
public class DemoConsumeRestApiRestTemplateApplication implements CommandLineRunner {

	RestTemplate template=new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(DemoConsumeRestApiRestTemplateApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//getEmployee(201);
		getAllEmployees();
		//addNewEmployee();
		//modifyEmployeeDetails();
		//removeEmployee();
	}
	public void getEmployee(int id)
	{
		String restURL="http://localhost:3657/employeeAPI/employees/{id}";
		ResponseEntity<String> res=template.getForEntity(restURL, String.class, id);
		System.out.println(res.getBody());
	}
	public void getAllEmployees()
	{
		String restURL="http://localhost:3657/employeeAPI/employees";
		EmployeeDTO[] list=template.getForObject(restURL, EmployeeDTO[].class);
		for(EmployeeDTO e: list)
		System.out.println(e);
	}

	public void addNewEmployee()
	{
		Employee e=new Employee();
		e.setId(290);
		e.setFname("Bihari");
		e.setSalary(456000);
		e.setDepartmentId(50);
		
		String restURL="http://localhost:3657/employeeAPI/employees";
		String response=template.postForObject(restURL, e, String.class);
		System.out.println(response);
		//getEmployee(e.getId());
	}

	public void modifyEmployeeDetails()
	{
		int id=241;
		Employee e1=new Employee();
		e1.setId(id);
		e1.setFname("Ketan");
		e1.setDepartmentId(100);
		e1.setSalary(90000);
		
		String restURL="http://localhost:3657/employeeAPI/employees/{id}";
		template.put(restURL, e1,id);
		System.out.println("Record Updated Successfully.");
		getEmployee(id);
	}

	public void removeEmployee()
	{
		String restURL="http://localhost:3657/employeeAPI/employees/{id}";
		template.delete(restURL,241);
		System.out.println("Employee Details Removed Successfully....");
	}
}
