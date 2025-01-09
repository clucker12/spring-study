package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper dao;
	public ArrayList<MemberDTO> getlist(){
		return dao.getlist();
	}
	public MemberDTO getmember(String id) {
		return dao.getmember(id);
	}
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
}
