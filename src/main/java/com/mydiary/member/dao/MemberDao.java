package com.mydiary.member.dao;

import com.mydiary.member.vo.MemberVO;

public interface MemberDao {

	public int insertMember(MemberVO memberVO);
	public MemberVO selectMember(MemberVO memberVO);
	public MemberVO selectMemberOne(int userId);
	public int selectMemberCountEmail(String email);
	public int updateMember(MemberVO newProfile);
	public int deleteMember(int id);
}
