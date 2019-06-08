package com.jay.app.aop;



import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	Logger logger = LoggerFactory.getLogger(LogginAspect.class);

	@Pointcut("execution(* com.jay.app.controller.UserController.*(..))") // expression 
	private void usercontrollerrequests() {} 
	
	@Pointcut("execution(* com.jay.app.controller.FileController.*(..))") // expression 
	private void  filecontrollerrequests() {} 
	
	 @Before("usercontrollerrequests()")
	 public void doBeforeEntringTask(){
	
      logger.info("ENTERING INTO THE USER CONTROLLER CLASS");
	   
	 }
	 
	 @Before("filecontrollerrequests()")
	 public void doBeforeFileControllerMethod() {
		 logger.info("Entering to file controller class");;
	 }
	
	 @AfterReturning("usercontrollerrequests()")
	 public void doAfterReturningFromTask(){
		 
	    logger.info("AFTER RETURNING REPONSE SUCCESFULLY FROM USER CONTROLLER CLASS");	 
	   System.out.println("User controller called ");
	 }
	 
	 
	 @AfterThrowing("usercontrollerrequests()")
	 public void doAfterThrowingTask() {
		  logger.info("AFTER THROWING AN ERROR FROM USER CONTROLLER CLASS");
	 }
}
