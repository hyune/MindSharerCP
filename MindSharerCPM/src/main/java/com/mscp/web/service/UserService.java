package com.mscp.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscp.web.model.User;
import com.mscp.web.model.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;

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
