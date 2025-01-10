package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberSeriveceImpl implements MemberSerivece {
	@Autowired MemberMapper mapper;
	BCryptPasswordEncoder encoder;
	public MemberSeriveceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	public int loginCheck(String id, String pwd) {
		//select * from table where id = id
		//MemberDTO dto = mapper.getMember(id);
		ArrayList<MemberDTO> list = mapper.getData(id);
		//if(dto != null) { //일치하는 데이터 있음
		if( list.size() != 0 ) {//일치하는 데이터 있음
			MemberDTO dto = list.get(0);
			
			System.out.println(encoder.matches(pwd, dto.getPwd()));
			
			if(pwd.equals(dto.getPwd()) || encoder.matches(pwd, dto.getPwd())) {
				return 1;
			}
		}
		return 0;
	}
	public ArrayList<MemberDTO> getList(){
		//interface에서 먼저 적거 impl로 들어옴! 오버라이딩 하는 작업 ->그리고 membermapper에가서 호출을 함
		//return mapper.getList();
		return mapper.getData( null );
	}
	public MemberDTO getMember(String id) {
		ArrayList<MemberDTO> list = mapper.getData(id);
		return list.get(0);
	}
	public int register( MemberDTO dto ) {
		
		String securePwd = encoder.encode(dto.getPwd());
		System.out.println("pwd : " + dto.getPwd());
		System.out.println("securePwd : "+ securePwd);
		dto.setPwd(securePwd);
		
		int result = 0;
		try {
			result = mapper.register( dto );
		}catch (Exception e ) {
			e.printStackTrace();
		}
		
		return result;
	}
	public void keepLogin(String sessionId, String id) {
		mapper.keepLogin(sessionId,id);
	}
	public MemberDTO getSessionId(String sessionId) {
		return mapper.getSessionId(sessionId);
	}
	
}


















