package com.jay.app.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

	@Pointcut("execution(* com.jay.app.controller.*.*(..))") // expression 
	private void businessService() {} 
	
	 @Before("businessService()")
	 public void doBeforeEntringTask(){
	   System.out.println("Entering the User controller class");
	 }
	
	 @AfterReturning("businessService()")
	 public void doAroundTask(){
	   System.out.println("User controller called ");
	 }
}
