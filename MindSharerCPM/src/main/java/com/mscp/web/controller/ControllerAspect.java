package com.mscp.web.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
	Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	@Pointcut("execution(public * com.mscp.web.controller..*Controller.*(..)) && @target(org.springframework.stereotype.Controller)")
	public void controller(){
		logger.info("controller");
		
	}
	
	@Pointcut("controller() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void requestMapping() {
		logger.info("requestMapping");

	}
	
	@Before("requestMapping()")
	public void beforeRequest(JoinPoint point){
		logger.info("beforeRequest join point="+point.toString());
	}
}
