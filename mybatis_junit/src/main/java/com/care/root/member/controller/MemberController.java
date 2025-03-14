package com.care.root.member.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("index")
	public String index() {
		return "member/index";
	}
	@GetMapping("insertview")
	public String insertview() {
		return "member/insertview";
	}
	@PostMapping("insert")
	public String insert(MemberDTO dto) {
		int result = ms.insertMember(dto);
		if(result ==1) {
			return "redirect:index";
		}
		return "redirect:insertview";
	}
	@GetMapping("memberview")
	public String memberview(Model model) {
		ArrayList<MemberDTO> list = ms.getList();
		model.addAttribute("list",list);
		return "member/memberview";
	}
}
