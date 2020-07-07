package com.mongoCrud.asgn.service;

import java.util.List;


import com.mongoCrud.asgn.model.Role;

public interface roleService {
	
	//POST Request Services (Create)
	public Role createRole(Role role);
	
	//GET Request services
	public Role getRoleById(String id);
	public Role getRoleByNicNo(String nicNo);
	public List<Role> getByRoleType(String roleType);
	public List<Role> getByOrganizationAndRoleType(String organization, String roleType);
	
	//Update Request Service
	public Role updateRole(Role role, String id);
	
	//Delete Request Service
	public Role deleteRole(String id);

	
}
