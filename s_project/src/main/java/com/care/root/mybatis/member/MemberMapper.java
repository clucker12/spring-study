package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public ArrayList<MemberDTO> getlist();
	public MemberDTO getmember(String id);
	public int insert(MemberDTO dto);
}
