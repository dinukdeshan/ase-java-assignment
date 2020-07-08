package com.mongoCrud.asgn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoCrud.asgn.model.Role;
import com.mongoCrud.asgn.repository.RoleRepository;
import com.mongoCrud.asgn.service.roleService;
import com.mongodb.MongoException;

@Service
public class RoleServiceImpl implements roleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	//Create Service---------------------------------------------------------------------
	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	//------------------------------------------------------------------------------------
	
	//GET Services------------------------------------------------------------------------
	//Get all documents 
	public List<Role> getAll(){
		return roleRepository.findAll();
	}
	
	//Get documents by NIC no
	public Role getRoleByNicNo(String nicNo) {
		return roleRepository.findByNicNo(nicNo);
	}
	
	//Get documents by Id
	@Override
	public Role getRoleById(String id) {
		return roleRepository.findById(id).get();
	}
	
	//Get documents based on the Role Type
//	@Override
//	public List<Role> getByRoleType(String roleType){
//		return roleRepository.findByRoleType(roleType);
//	}
	
	//Get documents based on Organization and Role Type
	@Override
	public List<Role> getByOrganizationAndRoleType(String organization, String roleType){
		return roleRepository.findByOrganizationAndRoleType(organization, roleType);
	}
	
	//-------------------------------------------------------------------------------------
	
	//Update-------------------------------------------------------------------------------
	@Override
	public Role updateRole(Role role, String id) {
		if(roleRepository.findById(id).isPresent()) {
			Role existingRole = roleRepository.findById(id).get();
			existingRole.setOrganization(role.getOrganization());
			existingRole.setFirstName(role.getFirstName());
			existingRole.setLastName(role.getLastName());
			existingRole.setNicNo(role.getRoleType());
			existingRole.setLastUpdatedDate(new Date());
			return roleRepository.save(role);
		}
		else
            throw new MongoException("Record not found");
	}
	//-------------------------------------------------------------------------------------
	
	//Delete
	@Override
	public Role deleteRole(String id){
		if(roleRepository.findById(id).isPresent()) {
			Role existingRole = roleRepository.findById(id).get();
			roleRepository.delete(existingRole);
			return existingRole;
		}
		else
            throw new MongoException("Record not found");
	}	
	
}
