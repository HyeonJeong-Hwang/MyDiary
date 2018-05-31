package com.mydiary.memo.dao;

import java.util.List;

import com.mydiary.memo.vo.MemoVO;

public interface MemoDao {
	
	public List<MemoVO> selectMemoAll(int memberId);
	public MemoVO selectMemoOne(int memoId);
	public int insertMemo(MemoVO memoVO);
	public int updateMemo(MemoVO memoVO);
	public int deleteMemo(int id);
}
