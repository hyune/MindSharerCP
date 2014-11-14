package com.mscp.web.mybatis.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

abstract public class DAOMyBatis {
	private String RootNamespace = "mybatis";
	
	abstract protected String getNamespace();
	
	@Autowired
	protected SqlSessionTemplate temp;
	
	protected String getStatement(String id){
		return String.format("%s.%s.%s", RootNamespace, getNamespace(), id);
	}
}
