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

	@Override
	public boolean readCountMemberEmail(String email) {
		return this.memberDao.selectMemberCountEmail(email) > 0;
	}

	@Override
	public MemberVO readMemberOne(int userId) {
		return this.memberDao.selectMemberOne(userId);
	}

	@Override
	public boolean updateProfile(MemberVO newProfile) {
		return this.memberDao.updateMember(newProfile) > 0;
	}

	@Override
	public boolean deleteMember(int id) {
		return memberDao.deleteMember(id)>0;
	}

}
