package com.mydiary.schedule.dao;

import java.util.List;

import com.mydiary.schedule.vo.ScheduleVO;

public interface ScheduleDao {
	public int insertWeeklySchedule(ScheduleVO scheduleVO);
	public int insertDailySchedule(ScheduleVO scheduleVO);
	public List<ScheduleVO> selectMonthlySchedule(ScheduleVO date);
	public List<ScheduleVO> selectWeeklySchedule(ScheduleVO date);
	public ScheduleVO selectScheduleOne(int id);
	public int deleteSchedule(int id);
}
