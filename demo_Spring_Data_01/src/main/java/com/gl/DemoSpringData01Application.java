package com.gl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.service.CustomerServiceImpl;
import com.gl.service.EmployeeServiceImpl;

@SpringBootApplication
public class DemoSpringData01Application implements CommandLineRunner
{
	@Autowired CustomerServiceImpl service;
	
	@Autowired EmployeeServiceImpl empService;
	
	@Autowired EntityManager em;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringData01Application.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		/*
		 * service.insert(); service.getCustomer(1); service.delete(); service.update();
		 */		
		//service.getAllCustomer();
		//service.getCustomerAgeAndName();
		//service.getCustomerAboveAge(20);
		//service.getCustomerByMobileAndAge(10, "8%");
		/*
		 * service.getMaxAgeCustomer(); service.getMinAgeCustomer();
		 * service.getAverageCustomerAge();
		 */
		
		//service.getCustomerByNames("A6", "A4");
		
		//empService.getNoOfEmployeesByDepartment();
		empService.departmentWiseMaxSalary();
	}

}
