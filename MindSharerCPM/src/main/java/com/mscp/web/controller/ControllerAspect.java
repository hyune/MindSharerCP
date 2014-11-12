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

	@Pointcut("execution(public * com.mscp.web..controller.non.*Controller.*(..)) && @target(org.springframework.stereotype.Controller)")
	public void nonController(){
		logger.info("controller");
		
	}
	
	@Pointcut("execution(public * com.mscp.web..controller.auth.*Controller.*(..)) && @target(org.springframework.stereotype.Controller)")
	public void controller(){
		logger.info("controller");
		
	}
	
	@Pointcut("controller() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void authRequestMapping() {
		logger.info("requestMapping");

	}
	
	@Pointcut("nonController() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void nonRequestMapping() {
		logger.info("requestMapping");

	}
	
	@Before("nonRequestMapping()")
	public void nonRequest(JoinPoint point){
		logger.info("nonRequest join point="+point.toString());

		logging(point);
	}
	
	@Before("authRequestMapping()")
	public void authRequest(JoinPoint point){
		logger.info("authRequest join point="+point.toString());
		
		logging(point);
	}
	
	private void logging(JoinPoint point){
		if(point == null) return;
		
		String info = point.toLongString() + " " + point.getKind();
		
		Object[] objs = null;
		if((objs = point.getArgs())!=null){
			StringBuffer buff = new StringBuffer("\nparams = ");
			for(Object o : objs){
				buff.append(o.toString());
			}
			
			info += buff.toString();
		}
		
		logger.info(info);
	}
}
