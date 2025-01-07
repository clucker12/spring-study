package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.member.service.MemberServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class TestMember {
	@Autowired MemberController mc; //auto를 통해서 객체가 자동적으로 등록이 됨
	@Autowired MemberService ms;
	@Autowired MemberDAO dao;
	
	@Test
	public void testMc() {
		System.out.println("---mc => " + mc );
		assertNotNull(mc);//해당하는 객체가 null값인지 아닌지 알려주는 역할임 
	}
	
	@Test
	public void testMs() {
		
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("홍길동");
		
		int result = ms.insertMember(dto);
		System.out.println("result : " + result);
		assertEquals(1, result);
		
		assertNotNull(ms);//해당하는 객체가 null값인지 아닌지 알려주는 역할임 
	}
	
	@Test
	public void testDao() {
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("홍길동");
		
		int result = dao.insertMember(dto);
		System.out.println("result : " + result);
		assertEquals(1, result);
		assertNotNull(dao);//해당하는 객체가 null값인지 아닌지 알려주는 역할임 
	}
	@Test
	public void getList() {
		ArrayList<MemberDTO> list = dao.getList();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
		assertNotSame(0, list.size());
	}
	
}





