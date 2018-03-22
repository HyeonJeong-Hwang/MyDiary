package com.mydiary.member.dao;

import com.mydiary.member.vo.MemberVO;

public interface MemberDao {

	public int insertMember(MemberVO memberVO);
	public MemberVO selectMember(MemberVO memberVO);
}
