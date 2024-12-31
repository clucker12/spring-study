package com.care.member.cotroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ser;
	public MemberController() {
		
	}
	
	@RequestMapping("index")
	public String index() {
		return "/member/index";
	}
	@RequestMapping("register")
	public String register() {
		return "/member/register";
	}
	@PostMapping("reg")
	public String reg(MemberDTO dto,Model model) {
		ArrayList<MemberDTO> list  = ser.membersave(dto);
		System.out.println("list :" + list.size());
		return "/member/index";
	}
	@GetMapping("memberlist")
	public String memberlist(Model model) {
		ArrayList<MemberDTO> list  = ser.memberlist();
		model.addAttribute("list",list);
		return "member/memberlist";
	}
}

