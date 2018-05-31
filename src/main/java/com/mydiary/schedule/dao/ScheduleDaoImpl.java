package com.mydiary.schedule.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mydiary.schedule.vo.ScheduleVO;

public class ScheduleDaoImpl extends SqlSessionDaoSupport implements ScheduleDao{

	@Override
	public int insertWeeklySchedule(ScheduleVO scheduleVO) {
		return getSqlSession().insert("ScheduleDao.insertWeeklySchedule", scheduleVO);
	}

	@Override
	public int insertDailySchedule(ScheduleVO scheduleVO) {
		return getSqlSession().insert("ScheduleDao.insertDailySchedule", scheduleVO);
	}

	@Override
	public List<ScheduleVO> selectMonthlySchedule(ScheduleVO date) {
		return getSqlSession().selectList("ScheduleDao.selectMonthlySchedule", date);
	}

	@Override
	public List<ScheduleVO> selectWeeklySchedule(ScheduleVO date) {
		return getSqlSession().selectList("ScheduleDao.selectWeeklySchedule", date);
	}

	@Override
	public ScheduleVO selectScheduleOne(int id) {
		return getSqlSession().selectOne("ScheduleDao.selectScheduleOne", id);
	}

	@Override
	public int deleteSchedule(int id) {
		return getSqlSession().delete("ScheduleDao.deleteSchedule", id);
	}

}
