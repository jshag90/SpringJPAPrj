package com.ji.valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ji/regist")
public class ValidController {

	private static final String MEMBER_REGISTRATION_FROM = "member/registrationForm";

	private MemberService memeberService;

	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute("memberInfo") MemberRegistRequest memReg, BindingResult bindingResult) {
		new MemeberRegistValidator().validate(memReg, bindingResult);

		if (bindingResult.hasErrors()) {
			return MEMBER_REGISTRATION_FROM;
		}
		
		return "";
	}

}
