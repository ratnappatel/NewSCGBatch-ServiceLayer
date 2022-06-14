package com.infy.ui;

import java.util.Scanner;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.infy.controller.CustomerLoginController;
import com.infy.dto.CustomerLoginDTO;

// Unit Testing for this UIInterface
public class UserInterface {

	private static final Log LOGGER = LogFactory.getLog(UserInterface.class);
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		PropertiesConfiguration config = new Configurations().properties("configuration.properties");
		try {
			CustomerLoginDTO customerLoginDTO = new CustomerLoginDTO();
			
			System.out.println("Enter Your Login Name");
			customerLoginDTO.setLoginName(sc.next());
			
			System.out.println("Enter Your Password");
			customerLoginDTO.setPassword(sc.next());
			
			CustomerLoginController customerLoginController = new CustomerLoginController();
			String message = customerLoginController.authenticateCustomer(customerLoginDTO);
			
			String key=message;
			
			LOGGER.info(config.getProperty(key));
		} catch (Exception exception) 
		{
			String key=exception.getMessage();
			LOGGER.info(config.getProperty(key));
		}
	}
}
