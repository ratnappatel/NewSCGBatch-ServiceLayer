package com.gl.service;

import java.util.List;

import com.gl.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer c);
	public Customer findCustomer(int id);
	public Customer modifyCustomer(Customer c,int id)throws Exception;
	public String deleteCustomer(int id);
	public List<Customer> getAllCustomer();
	public Customer getCustomerByMobile(String mobile);

}
