package com.ji.application;

import java.util.List;

import com.ji.domain.Employee;

public interface EmployeeListServcie {

	public List<Employee> getEmployee(String keyword, Long teamId);

}
