package com.ji.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.valid.MemberService;

@Controller
@RequestMapping("/auth/login")
public class LoginController {
	
		private static final String LOGIN_FORM="auth/loginForm";
		private Authenticator authenticator;
		
		@RequestMapping(method=RequestMethod.GET)
		public String loginForm(LoginCommand loginCommand) {
			return LOGIN_FORM;
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String login(@Valid LoginCommand loginCommand, Errors errors, 
								HttpServletRequest request) {
			
			if (errors.hasErrors()) {
				return LOGIN_FORM;
			}
			
			try {
					System.out.println(loginCommand.getEmail());
					System.out.println( loginCommand.getPassword());
					
					MemberService memberService = new MemberService();
					
					authenticator = new Authenticator(memberService);
					Auth auth = authenticator.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
					HttpSession session = request.getSession();
					session.setAttribute("auth", auth);
					return "redirect:/index";
					
			}catch(AuthenticationException ex){
					errors.reject("invalidIdOrPassword");
					return LOGIN_FORM;
			}
			
		}
		
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.setValidator(new LoginCommandValidator());
		}
	
		public void setAuthenticator(Authenticator authenticator) {
			this.authenticator = authenticator;
		}

}
