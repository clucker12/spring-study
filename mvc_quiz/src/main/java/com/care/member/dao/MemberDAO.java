package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}
	
	public ArrayList<MemberDTO>Memberadd(String id, String pwd, String name) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setPwd(pwd);
		list.add(dto);
		return list;
	}
	
	public ArrayList<MemberDTO>memberlist() {
		return list;
	}
}
