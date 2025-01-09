package com.care.root.member.service;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public ArrayList<MemberDTO> getlist();
	public MemberDTO getmember(String id);
	public int insert(MemberDTO dto);
}
