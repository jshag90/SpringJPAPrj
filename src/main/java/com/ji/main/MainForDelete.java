package com.ji.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ji.domain.EmployeeRepository;

public class MainForDelete {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");
		
		EmployeeRepository empRepository = ctx.getBean(EmployeeRepository.class);
		empRepository.delete(9L);
		ctx.close();
		
	}

}
