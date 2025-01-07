package com.care.root.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
	@GetMapping("make_session")
	public String makeSession(HttpServletRequest req,
			HttpSession se) {
		HttpSession s = req.getSession();
		s.setAttribute("name", "홍길동");
		se.setAttribute("id", "aaaa");
		return "session/makeSession"; 
	}
	@GetMapping("result_session")
	public String result_session(HttpSession session, Model model) {
		model.addAttribute("addr","산골짜기");
		model.addAttribute("id","model id");
		
		System.out.println("id : " + session.getAttribute("id"));
		System.out.println("name : " + session.getAttribute("name"));
		System.out.println("없는값 : " + session.getAttribute("없는값"));
		return "session/result_session";
	}
	@GetMapping("del_session")
	public String delSession(HttpSession session) {
		//session.removeAttribute("id"); // 특정 세션 만료
		session.invalidate(); // 모든 세션 만료
		return "session/del_session";
	}
}
