package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.entity.Customer;
import com.gl.service.CustomerService;

@RestController
// this class defines mapping of URI == Method which need to be invoked 
public class CustomerController {
	@Autowired CustomerService service;
	
	// Mapping this method invocation to start when given URI
	//is executed in browser/REST-Client using HTTP GET Method
	// {id} = path variable which will read the input from customer/client
	@GetMapping("/customers/{custId}")
	public Customer getCustomer(@PathVariable("custId")Integer id)
	{
		System.out.println("1. In Controller");
		Customer c=service.getCustomerDetails(id);
		return c;
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomer();
	}
	

	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer c)
	{
		return service.addCustomer(c);
	}

	@PutMapping("/customers/{custId}")
	public String modifyCustomerDetails(@PathVariable("custId")Integer id,@RequestBody Customer c)
	{
		String result=service.updateCustomerDetails(c,id);
		if(result.equalsIgnoreCase("success"))
			return "Customer Details Updated Successfully..";
		else
			return "Customer Does Not Exists with ID :"+id;
	}
	
	@DeleteMapping("/customers/{custId}")
	public String deleteCustomerDetails(@PathVariable("custId")Integer id)
	{
		String result=service.removeCustomer(id);
		if(result.equalsIgnoreCase("success"))
			return "Customer Details Removed Successfully...";
		else
			return "Customer details does not exists..";
		
	}
}
