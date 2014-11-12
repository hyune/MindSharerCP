package com.mscp.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscp.web.model.User;
import com.mscp.web.model.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public User login(String uid, String upw){
		User user = new User();
		user.setUid(uid);
		user.setUpw(upw);
		
		User result = dao.login(user);
		
		if(result == null){
			//TODO 사용자가 없가나 패스워드가 틀릴경우 Exception 처리 필요
		}
		
		return result;
	}

	public User select(String uid){
		return dao.select(uid);
	}
	
	public boolean checkRedundancy(String uid){
		return dao.checkRedundancy(uid);
	}
	
	public boolean insert(User dto){
		return dao.insert(dto)>0;
	}
}
