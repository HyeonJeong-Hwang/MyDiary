package com.mydiary.schedule.service;

import java.util.List;

import com.mydiary.schedule.vo.ScheduleVO;

public interface ScheduleService {
	
	public boolean insertWeeklySchedule(ScheduleVO scheduleVO);
	public boolean insertDailySchedule(ScheduleVO scheduleVO);
	public List<ScheduleVO> readMonthlySchedule(ScheduleVO date);
	public List<ScheduleVO> readWeeklySchedule(ScheduleVO date);
	public ScheduleVO readScheduleOne(int id);
	public boolean deleteSchedule(int id);
}
