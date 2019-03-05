package com.ji.springstudyjpa;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.domain.EmployeeRepository;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

		EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
		Sort sort = new Sort(
				new Order(Direction.DESC, "team.id"),
				new Order(Direction.ASC, "name")
			);
		
		
		model.addAttribute("EMP_REPO_LIST", 	empRepo.findAll(sort));

		
		return "home";
	}
	
}
