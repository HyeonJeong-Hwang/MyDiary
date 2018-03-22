package com.mydiary.member.service;

import com.mydiary.member.dao.MemberDao;
import com.mydiary.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public boolean createMember(MemberVO member) {
		return this.memberDao.insertMember(member) > 0;
	}

	@Override
	public MemberVO readMember(MemberVO member) {
		return this.memberDao.selectMember(member);
	}

}
