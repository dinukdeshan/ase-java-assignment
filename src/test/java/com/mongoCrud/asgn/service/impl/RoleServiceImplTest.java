package com.mongoCrud.asgn.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongoCrud.asgn.model.Role;
import com.mongoCrud.asgn.repository.RoleRepository;

class RoleServiceImplTest {
	
	@InjectMocks
	RoleServiceImpl roleService;	
	
	@Mock
	private RoleRepository roleRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testGetRoleById() {
		Role role = new Role("testOrg", "Test", "Name", "00000", "Driver");
		Optional<Role> allRoles =Optional.of(role);
		when(roleRepository.findById(anyString())).thenReturn(allRoles);
		
		Role testRole = roleService.getRoleById("testId");
		
		assertNotNull(testRole);
		assertEquals("Test", testRole.getFirstName());
	}
	
	@Test
	final void testGetRoleByNic() {
		Role role = new Role("testOrg2", "Test2", "Name2", "T0000", "Driver");
		
		when(roleRepository.findByNicNo(anyString())).thenReturn(role);
		
		Role testRole = roleService.getRoleByNicNo("testNic");
		
		assertNotNull(testRole);
		assertEquals("Test2", testRole.getFirstName());
	}
	
	

}
