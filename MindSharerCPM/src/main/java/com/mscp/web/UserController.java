package com.mscp.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mscp.web.model.ResponseModel;
import com.mscp.web.model.User;
import com.mscp.web.service.UserService;

@Controller
@RequestMapping("/adduser")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public String addUser() {
		return "memberregister";
	}
	
	@RequestMapping(value="/redundancy", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseModel<String> redundancyCheck(@RequestBody Map params){
		String uid = (String) params.get("uid");
		
		logger.info("redundancyCheck uid="+uid);
		
		ResponseModel<String> result = new ResponseModel<String>();
		if(uid!=null){
			boolean check = service.checkRedundancy(uid);
			result.setStatus(0);
			result.setResult(check ? "Y" : "N");
		}else{
			result.setStatus(1);
		}
		
		return result;
	}

	@RequestMapping(value="/result", 
			method = RequestMethod.POST)
	public @ResponseBody ResponseModel<User> addUserResult(@RequestBody User user) {
		logger.info("addUser json=" + user.toString());
		User inUser= null;
		
		user.setDeviceId("12345678"); //임시 저장
		
		ResponseModel<User> result = new ResponseModel<User>();
		
		boolean iResult = service.insert(user);
		
		if(iResult){
			inUser = service.select(user.getUid());
			result.setStatus(0);
			result.setResult(inUser);
		}else{
			result.setStatus(1);
		}
		
		
		return result;
	}
}
