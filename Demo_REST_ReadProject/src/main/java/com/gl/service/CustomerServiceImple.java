package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Customer;
import com.gl.repository.CustomerRepository;

@Service
public class CustomerServiceImple implements CustomerService{

	@Autowired CustomerRepository repository;

	@Override
	public Customer getCustomerDetails(int id) {
		System.out.println("2. In Service Impl Class");
		return repository.findById(id).get();
	}

	@Override
	public List<Customer> getAllCustomer() {
	List<Customer> customers=(List<Customer>) repository.findAll();
		return customers;
	}

	@Override
	public Customer addCustomer(Customer c) {
		return repository.save(c);
	}

	@Override
	public String updateCustomerDetails(Customer c, int id) {
		Customer existingCustomer=repository.findById(id).get();
		if(existingCustomer!=null)
		{
			existingCustomer.setName(c.getName());
			existingCustomer.setEmailId(c.getEmailId());
			existingCustomer.setDateOfBirth(c.getDateOfBirth());
			repository.save(existingCustomer);
		}
		else
			return "fail";
		return "Success";
	}

	@Override
	public String removeCustomer(int id) {
		repository.deleteById(id);
		return "Success";
	}
	
}
