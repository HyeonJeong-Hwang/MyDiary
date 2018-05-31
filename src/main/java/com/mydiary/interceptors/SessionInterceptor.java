package com.mydiary.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mydiary.member.contants.Member;


public class SessionInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception{
		
		String contextPath = request.getContextPath();
		
		if(request.getSession().getAttribute(Member.USER) == null) {
			response.sendRedirect(contextPath+"/login");
			return false;
		}
		return true;
	}
}
