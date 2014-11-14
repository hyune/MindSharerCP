package com.mscp.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscp.web.model.TimeLineDAO;
import com.mscp.web.model.TimeLineUser;

@Service
public class TimeLineService {

	@Autowired
	private TimeLineDAO dao;
	
	public List<TimeLineUser> selectAllWithUser(String uid){
		if(uid == null || uid.length()==0){
			//TODO Exception 처리
		}
		
		return dao.selectAllWithUser(uid);
	}
}
