package com.mydiary.schedule.vo;

public class ScheduleVO {

	public int scheduleId;
	public String scheduleDate;
	public String scheduleType;
	public String scheduleMemo;
	public int weekth;
	public String scheduleBody;
	public String scheduleTitle;
	public int memberId;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getScheduleMemo() {
		return scheduleMemo;
	}

	public void setScheduleMemo(String scheduleMemo) {
		this.scheduleMemo = scheduleMemo;
	}

	public int getWeekth() {
		return weekth;
	}

	public void setWeekth(int weekth) {
		this.weekth = weekth;
	}

	public String getScheduleBody() {
		return scheduleBody;
	}

	public void setScheduleBody(String scheduleBody) {
		this.scheduleBody = scheduleBody;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
