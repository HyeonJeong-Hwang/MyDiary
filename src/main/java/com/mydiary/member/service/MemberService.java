package com.mydiary.member.service;

import com.mydiary.member.vo.MemberVO;

public interface MemberService {

	public boolean createMember(MemberVO member);
	public MemberVO readMember(MemberVO member);
	public boolean readCountMemberEmail(String email);
	public MemberVO readMemberOne(int userId);
	public boolean updateProfile(MemberVO newProfile);
	public boolean deleteMember(int id);

}
