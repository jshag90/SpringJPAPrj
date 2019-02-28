package com.ji.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ji.application.UpdateEmployeeService;
import com.ji.domain.Address;

public class MainForUpdate {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

		UpdateEmployeeService updateEmpSvc = ctx.getBean(UpdateEmployeeService.class);

		updateEmpSvc.updateEmployee(new UpdateRequest(1L, new Address("서울시", "관악구", "123456")));

		ctx.close();

	}

}
