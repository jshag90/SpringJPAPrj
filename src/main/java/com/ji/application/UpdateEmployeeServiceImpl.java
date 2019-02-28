package com.ji.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ji.domain.Employee;
import com.ji.domain.EmployeeRepository;
import com.ji.main.UpdateRequest;

public class UpdateEmployeeServiceImpl implements UpdateEmployeeService {
	
	@Autowired(required=false)
	private EmployeeRepository emploeeRepository;

	@Transactional 
	@Override
	public void updateEmployee(UpdateRequest updateReq) {
		Employee employee = emploeeRepository.findOne(updateReq.getEmployeeId());
		if(employee == null)
			throw new EmployeeNotFoundException();
		
		employee.setAddress(updateReq.getNewAddress());
		
	}

}
