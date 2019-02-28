package com.ji.application;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;

import com.ji.domain.Employee;
import com.ji.domain.EmployeeRepository;

import static com.ji.domain.EmployeeSpec.employeeNumberEq;
import static com.ji.domain.EmployeeSpec.joinedDateGt;
import static com.ji.domain.EmployeeSpec.nameEq;
import static com.ji.domain.EmployeeSpec.teamIdEq;

import static org.springframework.data.jpa.domain.Specifications.where;

public class SpecEmployeeListService implements EmployeeListServcie {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	@Override
	public List<Employee> getEmployee(String keyword, Long teamId) {

		if (hasValue(keyword) || hasValue(teamId)) {
			if (hasValue(keyword) && !hasValue(teamId)) {
				return employeeRepository.findAll(where(nameEq(keyword)).or(employeeNumberEq(keyword)));
			} else if (!hasValue(keyword) && hasValue(teamId)) {
				return employeeRepository.findAll(teamIdEq(teamId));
			} else {
				Specifications<Employee> spec1 = where(nameEq(keyword)).or(employeeNumberEq(keyword));
				return employeeRepository.findAll(spec1.and(teamIdEq(teamId)));
			}

		} else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -30);

			return employeeRepository.findAll(joinedDateGt(cal.getTime()));
		}

	}

	private boolean hasValue(Object value) {
		return value != null;
	}

	private boolean hasValue(String value) {
		return value != null && !value.trim().isEmpty();
	}

}
