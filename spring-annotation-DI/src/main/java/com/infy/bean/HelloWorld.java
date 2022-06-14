package com.infy.bean;

import org.springframework.stereotype.Component;

 // When IOC container scans this class and finds 
//@Component marked will consider it as dependency

@Component
public class HelloWorld {
	
	public String sayHelo(String name)
	{
		return "Hello "+name;
	}

}
