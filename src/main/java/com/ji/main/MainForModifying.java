package com.ji.main;

import com.ji.application.UpdateTeamService;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForModifying {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

		UpdateTeamService updateTeamService = ctx.getBean(UpdateTeamService.class);
		updateTeamService.updateName(1L, "SWÆÀ");
		ctx.close();
	}
}
