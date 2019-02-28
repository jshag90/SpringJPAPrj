package com.ji.valid;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class ValidVo {
	
	@Size(min=5, max=10)private String id; 
	@Valid
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
