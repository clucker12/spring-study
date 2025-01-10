package com.care.root.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberSerivece;

public class AutoLogin extends HandlerInterceptorAdapter{
	@Autowired MemberSerivece ms;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---- auto login ----");
		Cookie cook = WebUtils.getCookie(request, "loginCookie");
		
		if(cook != null) {
			System.out.println("cook : " + cook.getValue());
			MemberDTO dto = ms.getSessionId(cook.getValue());
			System.out.println("dot : "+dto);
			if(dto != null) {
				request.getSession().setAttribute("username", dto.getId());
			}
		}
		return true;
	}
	
}
