package com.mydiary.memo.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mydiary.memo.vo.MemoVO;

public class MemoDaoImpl extends SqlSessionDaoSupport implements MemoDao{

	@Override
	public List<MemoVO> selectMemoAll(int memberId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("MemoDao.selectMemoAll", memberId);
	}

	@Override
	public MemoVO selectMemoOne(int memoId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MemoDao.selectMemoOne", memoId);
	}

	@Override
	public int insertMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("MemoDao.insertMemo", memoVO);
	}

	@Override
	public int updateMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return getSqlSession().update("MemoDao.updateMemo", memoVO);
	}

	@Override
	public int deleteMemo(int id) {
		return getSqlSession().delete("MemoDao.deleteMemo", id);
	}

}
