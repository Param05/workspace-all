package com.library.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.library.service.BookLoanService;

@Aspect
@Component
public class LoggingAspect {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controller() {
	}

	@Before("controller()")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Entering in Method :  " + joinPoint.getSignature().getName());
		log.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		log.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		log.info("Target class : " + joinPoint.getTarget().getClass().getName());
	}

	@AfterReturning(pointcut = "execution(* com.library.service.BookLoanService.* (..))")
	public void doAccessCheck() {
		log.info("method is " + BookLoanService.class);
	}

	/*@Around("execution(* com.library.model.Book.BookLoanService(..))")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Before invoking getName() method");
		Object value = null;

		value = proceedingJoinPoint.proceed();

		System.out.println("After invoking getName() method. Return value=" + value);
		return value;
	}
*/
}