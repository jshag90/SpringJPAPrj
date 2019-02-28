package com.ji.auth;

import com.ji.valid.MemberInfo;
import com.ji.valid.MemberService;

public class Authenticator {
	
	private MemberService memberService;
	
	public Authenticator(MemberService memberService) {
			this.memberService = memberService;
	}
	
	public Auth authenticate(String email, String password) {
		System.out.println("authenticate()");
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if(mi == null)
			throw new AuthenticationException();
		if(!mi.matchPassword(password))
			throw new AuthenticationException();
		
		return new Auth(mi.getId(), mi.getName());
	}

}
