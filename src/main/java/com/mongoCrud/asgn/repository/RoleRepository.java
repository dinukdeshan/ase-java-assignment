package com.mongoCrud.asgn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongoCrud.asgn.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
	//find by roleType
	public List<Role> findByRoleType(String roleType);
		
	//find by nicNO
	public Role findByNicNo(String nicNo); 
	
	//find by organization and role type
	@Query(value="{'organization':?0,'roleType':?1 }",fields="{'organization' : 0, 'roleType' :0,'lastUpdateDate':0}")
		public List<Role> findByOrganizationAndRoleType(String organization, String roleType);
}
