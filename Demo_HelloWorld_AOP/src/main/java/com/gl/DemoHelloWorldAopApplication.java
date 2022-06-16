package com.gl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.service.HelloWorldServiceImpl;

@SpringBootApplication
public class DemoHelloWorldAopApplication implements CommandLineRunner {

	@Autowired HelloWorldServiceImpl service;
	public static void main(String[] args) {
		SpringApplication.run(DemoHelloWorldAopApplication.class, args);
		
	}

	@Override // To provide an output on standard output device we must override run function
	public void run(String... args) throws Exception {
		//int res=service.product(10, 5);
		//System.out.println("The Product is "+res);
		service.product(10,20);
		
	}

}
