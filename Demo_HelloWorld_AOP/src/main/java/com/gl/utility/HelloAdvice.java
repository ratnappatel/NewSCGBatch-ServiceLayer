package com.gl.utility;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAdvice {
	
	@Before("execution(public * com.gl.service.*Impl.*(..))")
	public void beforeProductCalled()
	{
		System.out.println("Before Finding The Product .....");
	}
	
	@After("execution(public * com.gl.service.*Service*.*(..))")
	public void afterProductCalled()
	{
		System.out.println("After Finding The Product .....");
	}
	
	@AfterThrowing()
	public void exceptionInProduct()
	{
		System.out.println("Exception Occured during method execution..");
	}
	
	@AfterReturning()
	public void returningTheProduct()
	{
		
	}

}
