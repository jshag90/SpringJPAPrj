package com.ji.main;

import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ji.domain.Address;
import com.ji.domain.Employee;
import com.ji.domain.EmployeeRepository;
import com.ji.domain.Team;

public class MainForSave {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");
			
		EmployeeRepository empRepository = ctx.getBean(EmployeeRepository.class);
		Employee emp = new Employee("1234567896", "이도", new Address("서울시 종로구", "통인동", " 110043"), 1996, new Team(1L, "SW개발팀"), new Date());
		empRepository.save(emp);
		
		ctx.close();
		
	}

}
