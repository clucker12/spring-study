package com.care.root.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("logincheck")
	public String logincheck(String id,String pwd,HttpSession session) {
		MemberDTO member = ms.getmember(id);
		String dbid = member.getId(), dbpwd = member.getPwd();
		System.out.println("id:"+id);
		if(dbid.equals(id) && dbpwd.equals(pwd)) {
			session.setAttribute("login", id);
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@GetMapping("successLogin")
	public String successLogin() {
		return "member/successLogin";
	}
	@GetMapping("logout")
	   public String logout(HttpSession session) {
	      session.invalidate();
	      return "redirect:index";
	}
	@GetMapping("memberinfo")
		public String memberInfo(Model model,HttpSession session) {
		System.out.println("session : "+session.getAttribute("login"));
		if(session.getAttribute("login") !=null) {
			ArrayList<MemberDTO> list = ms.getlist();
			model.addAttribute("list", list);
			return "member/memberInfo";
		}
		return "member/login";
		
	}
	@GetMapping("info")
	public String Info(@RequestParam("id") String id, Model model) {
		System.out.println("id : " + id);
		MemberDTO member = ms.getmember(id);
		model.addAttribute("member",member);
		return "member/info";
	}
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	@PostMapping("memberinsert")
	public String memberinsert(MemberDTO dto) {
		int result = ms.insert(dto);
		if(result ==1 ) {
			return "redirect:index";
		}
		return "redirect:register";
		
	}
	
}
