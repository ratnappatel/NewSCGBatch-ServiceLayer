package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	public Customer findByMobile(String mobile);
	// select * from customer where mobile=?
	public Customer findByName(String name);
	//select * from customer where name=?
}
