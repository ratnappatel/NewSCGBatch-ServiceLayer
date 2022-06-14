package com.infy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infy.bean.GreetingBean;

// A Special class used by IOC container to check & instantiate required dependency[objects]
//for your application has to be marked with @Configuration
@Configuration 
public class SpringConfig {
	
	@Bean
	public GreetingBean getGreetingBean()
	{
		return new GreetingBean();
	}

}
