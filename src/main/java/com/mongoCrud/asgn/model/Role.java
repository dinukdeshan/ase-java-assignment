package com.mongoCrud.asgn.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="Role")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Role {
	
	@Id private String id;
	private String organization;
	private String firstName;
	private String lastName;
	private String nicNo;
	private String roleType;
	
	@CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date lastUpdatedDate;
	
	public Role(String organization, String firstName, String lastName, String nicNo, String roleType) {
		this.organization=organization;
		this.firstName=firstName;
		this.lastName=lastName;
		this.nicNo=nicNo;
		this.roleType=roleType;
		
		this.createdDate=new Date();
		this.lastUpdatedDate=new Date();
	}
	
	public String getId() {
		return id;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNicNo() {
		return nicNo;
	}
	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
	
}
