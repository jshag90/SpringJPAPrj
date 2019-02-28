package com.ji.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ji.application.EmployeeListServcie;
import com.ji.domain.Employee;

public class MainForJpaCriteria {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");
		
		EmployeeListServcie listService = ctx.getBean("jpaEmployeeListServcie", EmployeeListServcie.class);
		
		printEmployees("Jpa Criteria 이용 : keyword = null, teamId = null", listService.getEmployee(null, null));
		
		printEmployees("Jpa Criteria 이용 : keyword = null, teamId = 1L", listService.getEmployee(null, 1L));
		
		printEmployees("Jpa Criteria 이용 : keyword = 1234567895, teamid = 1L", listService.getEmployee("1234567895", 1L));
		
		printEmployees("Jpa Criteria 이용 : kyeword = 최범균, teamId = 2L", listService.getEmployee("최범균", 1L));
		
		ctx.close();
		
	}

	private static void printEmployees(String title, List<Employee> employees) {
		printTitle(title);
		for(Employee emp : employees) {
			System.out.println(emp.toString());
		}
		
	}

	private static void printTitle(String title) {
		System.out.println("============= " + title);
	}

}
