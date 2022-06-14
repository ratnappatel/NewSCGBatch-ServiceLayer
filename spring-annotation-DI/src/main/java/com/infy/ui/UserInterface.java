package com.infy.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.infy.bean.HelloWorld;
import com.infy.config.SConfig;

public class UserInterface {

	public static final Log LOGGER = LogFactory.getLog(UserInterface.class); 
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SConfig.class);
		HelloWorld hw = (HelloWorld) applicationContext.getBean(HelloWorld.class);
		LOGGER.info(hw.sayHelo("Infosys"));
		
		Environment ev=applicationContext.getEnvironment();
		String message=ev.getProperty("greet");
		LOGGER.info(message);
	}

}
