package com.mscp.web.model;

import java.util.List;

public interface UserDAO {

	public List selectAll();
	
	public User select(String uid);
	
	public boolean checkRedundancy(String uid);
	
	public int insert(User dto);
	
	public int updateCP(User dto);
	
	public int updateNickName(User dto);
	
	public void delete(String uid);
}
