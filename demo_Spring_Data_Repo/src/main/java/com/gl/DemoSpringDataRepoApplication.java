package com.gl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@SpringBootApplication
// Acting as User-Interface
public class DemoSpringDataRepoApplication implements CommandLineRunner{

	@Autowired EmployeeService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataRepoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * List<Employee> emps=service.getAllEmployee(); for(Employee e:emps)
		 * System.out.println(e);
		 */
		
		System.out.println(service.getByID(120));
		
	}

}
