package com.lcp.service;

import java.util.List;

import com.lcp.model.Role;

public interface TestService {

	public String TestName(String name);
	
	public List<Role> getRoles();
	
	public void insertRoles(Role role);
}
