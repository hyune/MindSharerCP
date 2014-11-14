package com.mscp.web.mybatis.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mscp.web.model.User;
import com.mscp.web.model.UserDAO;

@Repository
public class UserDAOMyBatis extends DAOMyBatis implements UserDAO {
	
	@Override
	protected String getNamespace() {
		return "User";
	}
	
	@Override
	public List selectAll() {
		return temp.selectList(getStatement("selectAll"));
	}

	@Override
	public User select(String uid) {
		return temp.selectOne(getStatement("select"), uid);
	}
	
	@Override
	public User login(User user) {
		return temp.selectOne(getStatement("login"), user);
	}

	@Override
	public boolean checkRedundancy(String uid) {
		int count = temp.selectOne(getStatement("redundancyId"), uid);
		return count == 0;
	}
	
	@Override
	public int insert(User dto) {
		return temp.insert(getStatement("insert"), dto);
	}

	@Override
	public int updateCP(User dto) {
		return temp.update(getStatement("updateCp"), dto);
	}

	@Override
	public int updateNickName(User dto) {
		return temp.update(getStatement("updateNickName"), dto);
	}

	@Override
	public void delete(String uid) {
		temp.delete(getStatement("delete"), uid);
	}

}
