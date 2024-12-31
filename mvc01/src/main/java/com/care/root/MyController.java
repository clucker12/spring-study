package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	public MyController() {
		System.out.println("------my ctrl 생성자 ----------");
	}
	
	@RequestMapping("/index")
	public String test(Model model) {
		System.out.println("----- test 연동 -------");
		model.addAttribute("request","기본 페이지입니다.");
		return "/member/index";
	}
	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("test","로그아웃 되었습니다.");
		model.addAttribute("key","원하는 값");
		return "/member/logout";
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login","로그인 페이지 값 전달");
		mv.setViewName("/member/login");
		return mv;
	}	
}
