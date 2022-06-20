package com.gl.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		
		Customer c1=new Customer( "abc", "74635", 24, "Permanent address");
		
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
		Query query = entityManager.createQuery("SELECT c FROM Customer c");
		List<Customer> customers = query.getResultList();
		System.out.println(customers.size());
		Iterator<Customer> itr=customers.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
			
	}
	public Customer getCustomer(int id)
	{
		Customer c=entityManager.find(Customer.class,id);
		System.out.println("Customer Details whose id is 1 : \n"+c);
		return c;
	}
	
	public void getCustomerAgeAndName()
	{
		System.out.println("=======================================================");
		Query query=entityManager.createQuery("select c1.name, c1.age from Customer c1 ");
		List<Object[]> customers=query.getResultList();
		for(Object obj[]:customers)
			System.out.print(obj[0]+" is "+obj[1]+" Years Old\n");
	}

	public void getCustomerAboveAge(int customerAge)
	{
		//NameParameter called age is created during runtime
		Query query=entityManager.createQuery("select c from Customer c where c.age>:age");
		query.setParameter("age", customerAge);
		List<Customer> customers=query.getResultList();
		for(Customer c:customers)
			System.out.println(c);
	}
	
	public void getCustomerByMobileAndAge(int age, String mobile)
	{
		Query query=entityManager.createQuery
				("Select c from Customer c where age>:age and mobile like :mobile");
		query.setParameter("age", age);
		query.setParameter("mobile", mobile);
		List<Customer> customers=query.getResultList();
		for(Customer c:customers)
			System.out.println(c);
	}

	
	public void getMaxAgeCustomer()
	{
		Query query=entityManager.createQuery("select max(c.age) from Customer c");
		Integer maxAge=(Integer) query.getSingleResult();
		System.out.println("The Max Age among all customers : "+maxAge);
	}
	public void getMinAgeCustomer()
	{
		Query query=entityManager.createQuery("select min(c.age) from Customer c");
		Integer minAge=(Integer) query.getSingleResult();	
		System.out.println("The Min Age among all customers : "+minAge);
	}
	public void getAverageCustomerAge()
	{
		Query query=entityManager.createQuery("select avg(c.age) from Customer c");
		Double avgAge=(Double) query.getSingleResult();	
		System.out.println("The Average Age of all customers : "+Math.round(avgAge));
	}
	public void getCustomerByNames(String name1, String name2)
	{
		Query query=entityManager.createQuery("select c from Customer c where c.name IN (:name1, :name2)");
		query.setParameter("name1", name1);
		query.setParameter("name2", name2);
		List<Customer> customers=query.getResultList();
		for(Customer c: customers)
			System.out.println(c);
	}
}
