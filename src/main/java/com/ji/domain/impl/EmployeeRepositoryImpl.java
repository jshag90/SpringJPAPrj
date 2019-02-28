package com.ji.domain.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ji.domain.Employee;
import com.ji.domain.EmployeeCustomRepository;
import com.ji.domain.Option;

public class EmployeeRepositoryImpl implements EmployeeCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Option<Employee> getOptionEmployee(Long id) {
		Employee emp = entityManager.find(Employee.class, id);
		return Option.value(emp);
	}

}
