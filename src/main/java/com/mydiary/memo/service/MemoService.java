package com.mydiary.memo.service;

import java.util.List;

import com.mydiary.memo.vo.MemoVO;

public interface MemoService {
	public List<MemoVO> readMemoAll(int memberId);
	public MemoVO readMemoOne(int memoId);
	public boolean insertMemo(MemoVO memoVO);
	public boolean updateMemo(MemoVO memoVO);
	public boolean deleteMemo(int id);
}
