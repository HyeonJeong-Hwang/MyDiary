package com.mydiary.memo.service;

import java.util.List;

import com.mydiary.memo.dao.MemoDao;
import com.mydiary.memo.vo.MemoVO;

public class MemoServiceImpl implements MemoService{
	
	private MemoDao memoDao;
	
	public void setMemoDao(MemoDao memoDao) {
		this.memoDao = memoDao;
	}

	@Override
	public List<MemoVO> readMemoAll(int memberId) {
		// TODO Auto-generated method stub
		return memoDao.selectMemoAll(memberId);
	}

	@Override
	public MemoVO readMemoOne(int memoId) {
		// TODO Auto-generated method stub
		return memoDao.selectMemoOne(memoId);
	}

	@Override
	public boolean insertMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return memoDao.insertMemo(memoVO)>0;
	}

	@Override
	public boolean updateMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return memoDao.updateMemo(memoVO)>0;
	}

	@Override
	public boolean deleteMemo(int id) {
		return memoDao.deleteMemo(id)>0;
	}

	
}
