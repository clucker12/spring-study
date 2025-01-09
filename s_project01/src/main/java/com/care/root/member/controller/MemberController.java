package com.care.root.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberSerivece;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberSerivece ms;
	
	@GetMapping("login")
	public String loginForm() {
		return "/member/login";
	}
	
	@PostMapping("login")
	public String login(String id) {
		System.out.println("id : " + id );
		return "forward:login_check";
	}
	
	@PostMapping("login_check")
	public String loginCheck(String id, String pwd, HttpSession session ) {
		int result = ms.loginCheck(id, pwd);
		if(result == 1 ) {
			session.setAttribute("username", id);
			return "redirect:success";
		}
		return "redirect:login";
	}
	
	@GetMapping("success")
	public String successLogin() {
		return "member/successLogin";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("list", ms.getList());
		return "member/memberInfo";
	}
	
	@GetMapping("info")
	public String info(String id, Model model) {
		model.addAttribute("member", ms.getMember(id));
		return "member/info";
	}
	
	@GetMapping("reg_form")
	public String reg_form() {
		
		return "member/register";
	}
	
	@PostMapping("register")
	public String reg(MemberDTO dto) {
		System.out.println("reg실행!!!!!!!!!!!");
		int result = ms.register( dto );
		if(result == 1) {
			return "redirect:login";
		}
		return "redirect:reg_form";
	}
	
	

}
















