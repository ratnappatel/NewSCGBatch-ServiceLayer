package com.infy.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infy.bean.GreetingBean;
import com.infy.config.SpringConfig;

public class UserInterface {
	public static final Log LOGGER = LogFactory.getLog(UserInterface.class); 
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		GreetingBean welcomeBean = applicationContext.getBean(GreetingBean.class);
		LOGGER.info(welcomeBean.welcome("Ratna"));
	}

}
