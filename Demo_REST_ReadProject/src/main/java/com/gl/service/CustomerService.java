package com.gl.service;

import java.util.List;

import com.gl.entity.Customer;

public interface CustomerService
{
	public Customer getCustomerDetails(int id);
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer c);
}
