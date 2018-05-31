package com.mydiary.memo.vo;

public class MemoVO {

	private int memoId;
	private String memoTitle;
	private String memoBody;
	private String writeDate;
	private int memberId;

	public int getMemoId() {
		return memoId;
	}

	public void setMemoId(int memoId) {
		this.memoId = memoId;
	}

	public String getMemoTitle() {
		return memoTitle;
	}

	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}

	public String getMemoBody() {
		return memoBody;
	}

	public void setMemoBody(String memoBody) {
		this.memoBody = memoBody;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
