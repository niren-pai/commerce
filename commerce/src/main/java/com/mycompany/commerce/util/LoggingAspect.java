package com.mycompany.commerce.util;

import java.util.Arrays;
import java.util.logging.FileHandler;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	
	//the pointcut signature for identifying the join point for the execution of the advice
	@Pointcut("execution(public * com.mycompany.commerce..*.*(..))")
	public void allMethods() {}
	
	//one can have around, after, before advice
	@Around("allMethods()")
	public Object logMethodEntryAndExit(ProceedingJoinPoint joinPoint)
	{
	
		Object[] args = joinPoint.getArgs();
		
		logger.debug("Entering method {} - arguments {}", joinPoint.getSignature(), Arrays.toString(args));
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		logger.debug("Request: {}{} - Parameters {}", request.getMethod(), request.getRequestURI(), request.getParameterMap());
		
		try {
			Object result = joinPoint.proceed();
			
			logger.debug("Exiting Method {} - results {}", joinPoint.getSignature(), result);
			
			return result;
		}
		catch(Throwable e) {
			
			e.printStackTrace();
			
			return null;
		}
		

		
	}
	
}
