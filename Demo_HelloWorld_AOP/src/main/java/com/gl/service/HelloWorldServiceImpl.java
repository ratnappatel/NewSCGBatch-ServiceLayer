package com.gl.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl {
	
	public int product(int x,int y)throws Exception
	{
		System.out.println("Inside Product Function");
		int product=x*y;
		if(product>100)
			throw new Exception("Your Product of Nos is out of scope");
		return product;
	}

}
