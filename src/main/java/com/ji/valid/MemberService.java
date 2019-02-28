package com.ji.valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberService {

	private int nextMemberId = 0;
	private Map<String, MemberInfo> memberMap = new HashMap<String, MemberInfo>();

	public MemberService() {
		memberMap.put("m1", new MemberInfo("m1", "이상화", "sanghwa@sanghwa.com", "sanghwa", false, new Address()));
		memberMap.put("m2", new MemberInfo("m2", "김연아", "yuna@yuna.com", "yuna", false, new Address()));
		nextMemberId = 3;
	}

	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}

	public void modifyMemeberInfo(MemberModRequest modReq) {
		MemberInfo mi = memberMap.get(modReq.getId());
		if (mi == null)
			throw new MemberNotFoundException();
		if (!mi.matchPassword(modReq.getCurrentPassword()))
			throw new NotMatchPasswordException();

		mi.setEmail(modReq.getEmail());
		mi.setName(modReq.getName());
		mi.setAllowNoti(modReq.isAllowNoti());
		mi.setAddress(modReq.getAddress());
	}

	public List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}

	public void registNewMember(MemberRegistRequest memRegReq) {
		
		System.out.println(memRegReq.toString());
		System.out.println(memRegReq.getAddress().getAddress1());
		System.out.println(memRegReq.getAddress().getAddress2());
		System.out.println(memRegReq.getAddress().getZipcode());
		
		try {
			MemberInfo mi = new MemberInfo("m" + nextMemberId, 
					memRegReq.getName(), 
					memRegReq.getEmail(),
					memRegReq.getPassword(), 
					memRegReq.isAllowNoti(), 
					memRegReq.getAddress());
			
			memberMap.put(mi.getId(), mi);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public MemberInfo getMemberInfoByEmail(String email) {
		for (MemberInfo mi : memberMap.values()) {
			System.out.println(mi.toString());
			if (mi.getEmail().equals(email))
				return mi;
		}
		return null;
	}

}
