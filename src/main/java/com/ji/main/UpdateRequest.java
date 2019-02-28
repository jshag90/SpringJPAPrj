package com.ji.main;

import com.ji.domain.Address;

public class UpdateRequest {
	
	private Long employeeId; 
	private Address newAddress;
	
	public UpdateRequest(Long employeeId, Address newAddress) {
		super();
		this.employeeId = employeeId;
		this.newAddress = newAddress;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Address getNewAddress() {
		return newAddress;
	}
	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	} 
	

}
