package com.gl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Customer;
import com.gl.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired CustomerRepository repository;
	@Override
	public Customer addCustomer(Customer c) {
		Customer added=repository.save(c);
		return added;
	}

	@Override
	public Customer findCustomer(int id) {
		Customer c=repository.findById(id).get();
		return c;
	}

	@Override
	public Customer modifyCustomer(Customer c, int id)throws Exception {
		Optional<Customer> optional =repository.findById(id);
		Customer customer = optional.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
		customer.setAddress(c.getAddress());
		customer.setMobile(c.getMobile());
		customer.setName(c.getName());
		return customer;
	}

	@Override
	public String deleteCustomer(int id) {
		repository.deleteById(id);
		return "Success";
	}

}
