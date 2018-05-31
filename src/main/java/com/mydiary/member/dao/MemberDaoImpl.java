package com.mydiary.member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mydiary.member.vo.MemberVO;

public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao{

	@Override
	public int insertMember(MemberVO memberVO) {
		return getSqlSession().insert("MemberDao.insertMember", memberVO);
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		return getSqlSession().selectOne("MemberDao.selectMember", memberVO);
	}

	@Override
	public int selectMemberCountEmail(String email) {
		return getSqlSession().selectOne("MemberDao.selectMemberCountEmail", email);
	}

	@Override
	public MemberVO selectMemberOne(int userId) {
		return getSqlSession().selectOne("MemberDao.selectMemberOne", userId);
	}

	@Override
	public int updateMember(MemberVO newProfile) {
		return getSqlSession().update("MemberDao.updateMember", newProfile);
	}

	@Override
	public int deleteMember(int id) {
		return getSqlSession().delete("MemberDao.deleteMember", id);
	}

}
