package com.mscp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mscp.web.model.User;

@Aspect
@Component
public class ControllerAspect {
	Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	@Pointcut("execution(public * com.mscp.web..controller.non..*Controller.*(..)) && @target(org.springframework.stereotype.Controller)")
	public void nonController(){
		logger.info("controller");
		
	}
	
	@Pointcut("execution(public * com.mscp.web..controller.auth..*Controller.*(..)) && @target(org.springframework.stereotype.Controller)")
	public void controller(){
		logger.info("controller");
		
	}
	
	@Pointcut("controller() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void authRequestMapping() {
		logger.info("requestMapping ");

	}
	
	@Pointcut("nonController() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void nonRequestMapping() {
		logger.info("requestMapping ");

	}
	
	@Before("nonRequestMapping()")
	public void nonRequest(JoinPoint point){
//		logger.info("nonRequest requestMapping="+requestMapping);

		logging(point);
	}
	
	@Before("authRequestMapping()")
	public void authRequest(JoinPoint point) throws IllegalAccessException{
//		logger.info("authRequest requestMapping="+requestMapping);
//		logger.info("authRequest session myinfo="+session.getAttribute("myInfo"));
		
		logging(point);
		
		if(!checkSession()){
			throw new IllegalAccessException("No Auth Session");
		}
	}
	
	private boolean checkSession(){
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		if(ra!=null && ra instanceof ServletRequestAttributes){
			HttpServletRequest req = ((ServletRequestAttributes)ra).getRequest();
			User myinfo = (User) req.getSession().getAttribute("myInfo");
			
			logger.info("checkSession user="+myinfo);
			
			return myinfo != null;
		}
		return false;
	}
	
	private void logging(JoinPoint point){
		if(point == null) return;
		
		String info = point.toString();
		
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
