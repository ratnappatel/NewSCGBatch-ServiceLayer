package com.gl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gl.dto.EmployeeDTO;

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

}
