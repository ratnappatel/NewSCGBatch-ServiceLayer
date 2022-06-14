package com.infy.repository;

import java.util.HashMap;
import java.util.Map;

import com.infy.dto.CustomerLoginDTO;

public class CustomerLoginRepositoryImpl implements CustomerLoginRepository {
	
	public CustomerLoginDTO getCustomerLoginByLoginName(String loginName) {
		// JDBC Logic to connect with any database
		// since we are practicing a Service Layer 
		//we are creating a dummy DB as Hashmap object
		Map<String, String> customerCredentials = new HashMap<String, String>();
		customerCredentials.put("robin", "robin123");
		customerCredentials.put("harry", "harry123");
		customerCredentials.put("garry", "garry123");
		customerCredentials.put("monica", "monica123");
		CustomerLoginDTO customerLogin = new CustomerLoginDTO();
		customerLogin.setLoginName(loginName);
		// select password from customercredential where username="loginname"
		customerLogin.setPassword(customerCredentials.get(loginName));
		return customerLogin;
	}
}