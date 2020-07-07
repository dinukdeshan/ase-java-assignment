package com.mongoCrud.asgn.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.mongoCrud.asgn.model.Role;
import com.mongoCrud.asgn.repository.RoleRepository;

class RoleServiceImplTest {
	
	@Mock
	private RoleRepository roleRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetRoleById() {
		Role role = new Role("testOrg", "Test", "Name", "00000", "Driver");
		
		when(roleRepository.findById(anyString())).thenReturn(role);
	}

}
