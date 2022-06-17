package com.gl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.service.CustomerServiceImpl;

@SpringBootApplication
public class DemoSpringData01Application implements CommandLineRunner
{
	@Autowired CustomerServiceImpl service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringData01Application.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		service.insert();
		service.getCustomer(1);
		//service.update();
		service.delete();
		
	}

}
