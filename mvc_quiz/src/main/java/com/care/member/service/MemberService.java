package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	public ArrayList<MemberDTO> membersave(MemberDTO dto) {
		ArrayList<MemberDTO> list = dao.Memberadd(dto.getId(), dto.getPwd(), dto.getName());
		return list;
	}
	public ArrayList<MemberDTO> memberlist(){
		ArrayList<MemberDTO> list = dao.memberlist();
		return list;
	}
}
