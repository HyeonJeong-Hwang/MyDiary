package com.mydiary.schedule.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mydiary.member.contants.Member;
import com.mydiary.member.vo.MemberVO;
import com.mydiary.schedule.service.ScheduleService;
import com.mydiary.schedule.vo.ScheduleVO;

@Controller
public class ScheduleController {
	
	private ScheduleService scheduleService;
	
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@RequestMapping("/monthly")
	public ModelAndView viewNowMonthlyPage(HttpSession session) {
		Calendar calendar = Calendar.getInstance();
		int startDay; // 월 시작 요일
        int lastDay; // 월 마지막 날짜
        int year;
        int month;
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        String now = month<10?year+"-0"+month:year+"-"+month;
        
        String monthYearStr = month<10?year+"0"+month:year+""+month;
        
        int monthYear = Integer.parseInt(monthYearStr);
        
        calendar.set(Calendar.DATE, 1);
        startDay = calendar.get(Calendar.DAY_OF_WEEK); // 월 시작 요일
        lastDay = calendar.getActualMaximum(Calendar.DATE);
        
        MemberVO member = (MemberVO) session.getAttribute(Member.USER);
        ScheduleVO schedule = new ScheduleVO();
        
        schedule.setMemberId(member.getUserId());
        
        Map<String,List<ScheduleVO>> monthlySchedule = new HashMap<String,List<ScheduleVO>>();
        int var = monthYear*100;
        
        
        for(int i=var+1; i<var+lastDay+1;i++) {
        	schedule.setScheduleDate(i+"");
        	monthlySchedule.put(i+"", scheduleService.readMonthlySchedule(schedule));
        	
        }
        
		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/monthly");
		view.addObject("monthYear", monthYear);
		view.addObject("now", now);
		view.addObject("startDay", startDay);
		view.addObject("endDay",lastDay);
		view.addObject("monthlySchedule", monthlySchedule);
		return view; 
	}
	
	@RequestMapping("/monthly/{yearMonth}")
	public ModelAndView viewAnotherMonthlyPage(@PathVariable int yearMonth, HttpSession session) {
		Calendar calendar = Calendar.getInstance();
		int startDay; // 월 시작 요일
        int lastDay; // 월 마지막 날짜
        int year = yearMonth/100;
        int month = yearMonth%100;
        
        String now = month<10?year+"-0"+month:year+"-"+month;
        
        String monthYearStr = month<10?year+"0"+month:year+""+month;
        
        int monthYear = Integer.parseInt(monthYearStr);
        
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, 1);
        
        startDay = calendar.get(Calendar.DAY_OF_WEEK); // 월 시작 요일
        lastDay = calendar.getActualMaximum(Calendar.DATE);
        
        Map<String,List<ScheduleVO>> monthlySchedule = new HashMap<String,List<ScheduleVO>>();
        int var = monthYear*100;
        
        MemberVO member = (MemberVO) session.getAttribute(Member.USER);
        ScheduleVO schedule = new ScheduleVO();
        
        schedule.setMemberId(member.getUserId());
        
        for(int i=var+1; i<var+lastDay+1;i++) {
        	schedule.setScheduleDate(i+"");
        	monthlySchedule.put(i+"", scheduleService.readMonthlySchedule(schedule));
        	
        }

		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/monthly");
		view.addObject("monthYear", monthYear);
		view.addObject("now", now);
		view.addObject("startDay", startDay);
		view.addObject("endDay",lastDay);
		return view; 
	}
	
	@RequestMapping("/weekly")
	public ModelAndView viewWeeklyPage(HttpSession session) {
		
		Calendar calendar = Calendar.getInstance();
        int lastDay; // 월 마지막 날짜
        int year;
        int month;
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        
        String now = month<10?year+"-0"+month:year+"-"+month;
        
        String monthYearStr = month<10?year+"0"+month:year+""+month;
        
        int monthYear = Integer.parseInt(monthYearStr);

        lastDay = calendar.getActualMaximum(Calendar.DATE);
        
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        //주차 계산
        int weekth = calendar.get(Calendar.WEEK_OF_MONTH);
        
        int var = monthYear*100+1;
        ScheduleVO newVO = new ScheduleVO();
        newVO.setScheduleDate(var+"");
        
        MemberVO member = (MemberVO) session.getAttribute(Member.USER);
        newVO.setMemberId(member.getUserId());
        
        Map<String,List<ScheduleVO>> weeklySchedule = new HashMap<String,List<ScheduleVO>>();
        
        for(int i=1; i<=weekth;i++) {
        	newVO.setWeekth(i);
        	weeklySchedule.put(i+"", scheduleService.readWeeklySchedule(newVO));
        	
        }
        
		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/weekly");
		view.addObject("monthYear", monthYear);
		view.addObject("now", now);
		view.addObject("weekth", weekth);
		view.addObject("weeklySchedule", weeklySchedule);
		
		view.setViewName("schedule/weekly");
		return view; 
	}
	
	@RequestMapping("/weekly/{yearMonth}")
	public ModelAndView viewAnotherWeeklyPage(@PathVariable int yearMonth, HttpSession session) {
		
		Calendar calendar = Calendar.getInstance();
        int lastDay; // 월 마지막 날짜
        int year = yearMonth/100;
        int month = yearMonth%100;
        
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        
        lastDay = calendar.getActualMaximum(Calendar.DATE);
        
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        //주차 계산
        int weekth = calendar.get(Calendar.WEEK_OF_MONTH);
        String now = month<10?year+"-0"+month:year+"-"+month;
        
        String monthYearStr = month<10?year+"0"+month:year+""+month;
        
        int monthYear = Integer.parseInt(monthYearStr);
    
        int var = monthYear*100+1;
        ScheduleVO newVO = new ScheduleVO();
        newVO.setScheduleDate(var+"");
        
        MemberVO member = (MemberVO) session.getAttribute(Member.USER);
        newVO.setMemberId(member.getUserId());
        
        Map<String,List<ScheduleVO>> weeklySchedule = new HashMap<String,List<ScheduleVO>>();
        
        for(int i=1; i<=weekth;i++) {
        	newVO.setWeekth(i);
        	weeklySchedule.put(i+"", scheduleService.readWeeklySchedule(newVO));
        	
        }
        
		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/weekly");
		view.addObject("monthYear", monthYear);
		view.addObject("now", now);
		view.addObject("endDay",lastDay);
		view.addObject("weekth", weekth);
		view.addObject("weeklySchedule", weeklySchedule);
		view.setViewName("schedule/weekly");
		return view; 
	}
	
	@RequestMapping("/daily")
	public ModelAndView viewDailyPage(HttpSession session) {
		Calendar calendar = Calendar.getInstance();
		Calendar preCal = Calendar.getInstance();
		
        int year;
        int month;
        int date;
        int lastDate;
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        date = calendar.get(Calendar.DAY_OF_MONTH);
        lastDate = calendar.getActualMaximum(Calendar.DATE);
        
        String now = month<10?year+"-0"+month:year+"-"+month;
        now = date<10?now+"-0"+date:now+"-"+date;
        
        String monthYearStr = month<10?year+"0"+month:year+""+month;
        
        int monthYear = Integer.parseInt(monthYearStr);
        
        preCal.set(Calendar.MONTH, month-2);
        int preMonthLastDate = preCal.getActualMaximum(Calendar.DATE);
        
        int var = (monthYear*100)+date;
        
        MemberVO member = (MemberVO) session.getAttribute(Member.USER);
        ScheduleVO schedule = new ScheduleVO();
        
        schedule.setMemberId(member.getUserId());
        schedule.setScheduleDate(var+"");
        
        List<ScheduleVO> dailySchedule = scheduleService.readMonthlySchedule(schedule);
        
       
		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/daily");
		view.addObject("monthYear",monthYear);
		view.addObject("now", now);
		view.addObject("year", year);
		view.addObject("month", month);
		view.addObject("preCalDate", preMonthLastDate);
		view.addObject("lastDate", lastDate);
		view.addObject("date", date);
		view.addObject("dailySchedule", dailySchedule);
		return view; 
	}
	
	@RequestMapping("/daily/{date}")
	public ModelAndView viewAnotherDailyPage(@PathVariable int date, HttpSession session) {
		Calendar calendar = Calendar.getInstance();
		Calendar preCal = Calendar.getInstance();
		
        int year = date/10000;
        int day = date%100;
        int month = ((date-day)%10000)/100;

        
        
        String now = month<10?year+"-0"+month:year+"-"+month;
        now = day<10?now+"-0"+day:now+"-"+day;
        
        String monthYearStr = month<10?year+"0"+month:year+""+month;
        
        int monthYear = Integer.parseInt(monthYearStr);
        
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, day);
        
        preCal.set(Calendar.MONTH, month-2);
        int preMonthLastDate = preCal.getActualMaximum(Calendar.DATE);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        
        MemberVO member = (MemberVO) session.getAttribute(Member.USER);
        ScheduleVO schedule = new ScheduleVO();
        
        schedule.setMemberId(member.getUserId());
        schedule.setScheduleDate(date+"");
        
        List<ScheduleVO> dailySchedule = scheduleService.readMonthlySchedule(schedule);
        
		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/daily");
		view.addObject("monthYear",monthYear);
		view.addObject("preCalDate", preMonthLastDate);
		view.addObject("now", now);
		view.addObject("year", year);
		view.addObject("month", month);
		view.addObject("date", date);
		view.addObject("day", day);
		view.addObject("lastDate", lastDate);

		view.addObject("dailySchedule", dailySchedule);
		return view; 
	}
	
	@RequestMapping(value="/daily/write/{date}", method=RequestMethod.GET)
	public String viewDailyWritePage(@PathVariable int date) {
		
		return "/schedule/dailyWrite";
	}
	
	@RequestMapping(value="/daily/write/{date}", method=RequestMethod.POST)
	public String doDailyWritePage(@PathVariable int date,
			@ModelAttribute("dailyWriteForm") ScheduleVO scheduleVO, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		scheduleVO.setMemberId(member.getUserId());
		scheduleVO.setScheduleDate(date+"");
		scheduleVO.setScheduleType("d");
		
		boolean isSuccess = scheduleService.insertDailySchedule(scheduleVO);
		
		if(isSuccess) {
			return "redirect:/daily/"+date;
		}
		
		return "redirect:/daily/write/"+date;
	}
	
	@RequestMapping(value="/weekly/write"
			+ "/{monthYear}/{weekth}", method=RequestMethod.GET)
	public String viewWeeklyWritePage(@PathVariable int monthYear, @PathVariable int weekth) {
		
		return "/schedule/weeklyWrite";
	}
	
	@RequestMapping(value="/weekly/write/{monthYear}/{weekth}", method=RequestMethod.POST)
	public String doWeeklyWritePage(@PathVariable int monthYear, @PathVariable int weekth,
			@ModelAttribute("weeklyWriteForm") ScheduleVO scheduleVO, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		scheduleVO.setMemberId(member.getUserId());
		scheduleVO.setScheduleDate(monthYear+"");
		scheduleVO.setScheduleType("w");
		scheduleVO.setWeekth(weekth);
		
		boolean isSuccess = scheduleService.insertWeeklySchedule(scheduleVO);
		
		if(isSuccess) {
			return "redirect:/weekly/"+monthYear;
		}
		
		return "redirect:/weekly/write/"+monthYear+"/"+weekth;
	}
	
	
	@RequestMapping(value="/daily/dairy/{date}", method=RequestMethod.GET)
	public String viewDiaryWritePage(@PathVariable int date) {
		
		return "/schedule/dailyDiary";
	}
	
	@RequestMapping(value="/daily/dairy/{date}", method=RequestMethod.POST)
	public String doDiaryWritePage(@PathVariable int date,
			@ModelAttribute("dailyWriteForm") ScheduleVO scheduleVO, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		scheduleVO.setMemberId(member.getUserId());
		scheduleVO.setScheduleDate(date+"");
		scheduleVO.setScheduleType("d");
		
		boolean isSuccess = scheduleService.insertDailySchedule(scheduleVO);
		
		if(isSuccess) {
			return "redirect:/daily/"+date;
		}
		
		return "redirect:/daily/write/"+date;
	}
	
	
	@RequestMapping("/schedule/view/{id}")
	public ModelAndView viewSchedulePage(@PathVariable int id) {
		ModelAndView view = new ModelAndView();
		
		ScheduleVO schedule = scheduleService.readScheduleOne(id);
		
		view.addObject("schedule", schedule);
		view.setViewName("schedule/scheduleView");
		return view;
	}
	
	@RequestMapping("/schedule/delete/{id}")
	public String doDeleteSchedule(@PathVariable int id) {
		
		scheduleService.deleteSchedule(id);
		
		return "redirect:/monthly";
	}
	

}
