package com.mydiary.schedule.service;

import com.mydiary.schedule.dao.ScheduleDao;

public class ScheduleServiceImpl implements ScheduleService{

	private ScheduleDao scheduleDao;
	
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
}
