package com.mydiary.member.service;

import com.mydiary.member.vo.MemberVO;

public interface MemberService {

	public boolean createMember(MemberVO member);
	public MemberVO readMember(MemberVO member);

}
