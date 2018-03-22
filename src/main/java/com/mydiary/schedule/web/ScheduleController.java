package com.mydiary.schedule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mydiary.schedule.service.ScheduleService;

@Controller
public class ScheduleController {
	
	private ScheduleService scheduleService;
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	
	@RequestMapping("/")
	public ModelAndView viewMainPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("schedule/profile");
		return view;
	}
	

}
