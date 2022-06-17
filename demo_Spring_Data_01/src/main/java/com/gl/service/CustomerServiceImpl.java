package com.gl.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void insert() 
	{
		
		Customer c1=new Customer( "A3", "63487347", 18);
		
		entityManager.persist(c1);
		System.out.println("Customer Details Stored Successfully ....");
	}
	
	public void update() 
	{
		Customer c2=getCustomer(2);
		c2.setMobile("999999999");
		entityManager.merge(c2);
		System.out.println("Customer Details Updated Successfully...");
	}
	
	public void delete() 
	{
		Customer c=getCustomer(2);
		
		entityManager.remove(c);
		System.out.println("Customer details deleted successfully.");
	}
	public void getAllCustomer() 
	{
		
	}
	public Customer getCustomer(int id)
	{
		Customer c=entityManager.find(Customer.class,id);
		System.out.println("Customer Details whose id is 1 : \n"+c);
		return c;
	}
}
