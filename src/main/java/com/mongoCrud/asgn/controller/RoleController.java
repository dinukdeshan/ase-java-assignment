package com.mongoCrud.asgn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongoCrud.asgn.model.Role;
import com.mongoCrud.asgn.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl roleService;
	
	//Create
	@PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
	
	//Retrieve
	@GetMapping(value="/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Role>> getAll(){
		return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
	}
	
	//Retrieve by ID
	@GetMapping(value="/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Role> getRoleById(@PathVariable("id") String id) {
		return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
	}
		
	//Retrieve by Role Type
	@GetMapping(value="/roleType/{roleType}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Role>> getRole(@PathVariable("roleType") String roleType){
		return new ResponseEntity<>(roleService.getByRoleType(roleType), HttpStatus.OK);
	}
	
	//Retrieve by NIC no
	@GetMapping(value="/nicNo/{nicNo}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Role> getRoleByNic(@PathVariable("nicNo") String nicNo) {
		return new ResponseEntity<>(roleService.getRoleByNicNo(nicNo), HttpStatus.OK);
	}
	
	//Retrieve by organization and role
	@GetMapping(value="/organization/{organization}/roleType/{roleType}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Role>> getRoleByOrgAndRoleType(@PathVariable("organization") String organization,@PathVariable("roleType") String roleType){
		return new ResponseEntity<>(roleService.getByOrganizationAndRoleType(organization, roleType),HttpStatus.OK);
	}
	
	//Update-----------------------------------------------------------------------------------
	@PutMapping(value="/update/{id}")
	@ResponseStatus(HttpStatus.OK) 
	public ResponseEntity<Role> updateRole(@RequestBody Role role,@PathVariable("id") String id){
		return new ResponseEntity<>(roleService.updateRole(role, id),HttpStatus.OK);
	}
	//------------------------------------------------------------------------------------------
	
	//Delete
	@DeleteMapping(value="/delet/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Role> deleteRole(@PathVariable("id")String id) {
		return new ResponseEntity<>(roleService.deleteRole(id),HttpStatus.OK);
	}
	
	
	
}
