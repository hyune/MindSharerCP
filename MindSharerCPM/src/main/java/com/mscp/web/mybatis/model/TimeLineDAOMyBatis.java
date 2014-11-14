package com.mscp.web.mybatis.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mscp.web.model.TimeLineDAO;

@Repository
public class TimeLineDAOMyBatis extends DAOMyBatis implements TimeLineDAO {
	
	@Override
	protected String getNamespace() {
		return "TimeLine";
	}
	
	@Override
	public List selectAllWithUser(String uid) {
		return temp.selectList("selectAllWithUser", uid);
	}

}
