package com.infy.controller;

import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;
import com.infy.service.CustomerLoginService;
import com.infy.service.CustomerLoginServiceImpl;

public class CustomerLoginController {

	private CustomerLoginService customerLoginService;

	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws InfyBankException {
		customerLoginService=new CustomerLoginServiceImpl();
		//customerLoginService.m1();
		return customerLoginService.authenticateCustomer(customerLoginDTO);		
	}
}
