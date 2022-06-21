package com.gl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.entity.Customer;
import com.gl.service.CustomerService;

@SpringBootApplication
public class DemoGlBankAppApplication implements CommandLineRunner {

	@Autowired CustomerService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoGlBankAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c=new Customer( "Gargesh", "9601290547", "B-507 Dwarika Apartment");
		Customer added=service.addCustomer(c);
		System.out.println("Customer Details added succfully with ID : "+added.getId());
		
		Customer temp=service.findCustomer(added.getId());
		System.out.println(temp);
	}

}
