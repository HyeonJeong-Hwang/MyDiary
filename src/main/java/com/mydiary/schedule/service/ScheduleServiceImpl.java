package com.mydiary.schedule.service;

import java.util.List;

import com.mydiary.schedule.dao.ScheduleDao;
import com.mydiary.schedule.vo.ScheduleVO;

public class ScheduleServiceImpl implements ScheduleService{

	private ScheduleDao scheduleDao;
	
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public boolean insertWeeklySchedule(ScheduleVO scheduleVO) {
		return scheduleDao.insertWeeklySchedule(scheduleVO)>0;
	}

	@Override
	public boolean insertDailySchedule(ScheduleVO scheduleVO) {
		return scheduleDao.insertDailySchedule(scheduleVO)>0;
	}

	@Override
	public List<ScheduleVO> readMonthlySchedule(ScheduleVO date) {
		return scheduleDao.selectMonthlySchedule(date);
	}

	@Override
	public List<ScheduleVO> readWeeklySchedule(ScheduleVO date) {
		return scheduleDao.selectWeeklySchedule(date);
	}

	@Override
	public ScheduleVO readScheduleOne(int id) {
		return scheduleDao.selectScheduleOne(id);
	}

	@Override
	public boolean deleteSchedule(int id) {
		return scheduleDao.deleteSchedule(id)>0;
	}
}
