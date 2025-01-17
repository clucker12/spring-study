package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TestRestController {
	List<InfoDTO> list ;
	public TestRestController() {
		list = new ArrayList<InfoDTO>();
		for(int i = list.size(); i<=3; i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("홍길동" + i);
			dto.setAge(i * 10);
			list.add(dto);
		}
		
	}
	@GetMapping("test")
	public String test() {
		
		return "test";
	}
	
	@GetMapping(value = "rest",
			produces = "application/json; charset=utf-8")
	public Map<String, String> getRest() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("key", "get 데이터 요청시(select)");
		return map;
	}
	
	@PostMapping(value = "rest",
			produces = "application/json; charset=utf-8")
	public Map<String, String> postRest() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("key", "post 데이터 요청시(insert)");
		return map;
	}
	@PutMapping(value = "rest",
			produces = "application/json; charset=utf-8")
	public Map<String, String> putRest() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("key", "put 데이터 수정시(update)");
		return map;
	}

	@DeleteMapping(value = "rest",
			produces = "application/json; charset=utf-8")
	public Map<String, String> delRest() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("key", "delete 데이터 삭제시(delete)");
		return map;
	}
	
	
	@GetMapping(value = "members",
			produces = "application/json; charset=utf-8")
	public List<InfoDTO> memberList(){
		// select * from table;
//		List<InfoDTO> list = new ArrayList<InfoDTO>();

		return list;
	}
	
	@GetMapping(value = "members/{id}", 
			produces = "application/json; charset=utf-8")
	public InfoDTO info(@PathVariable String id) {
		for(InfoDTO d : list) {
			if(d.getName().equals(id)) {
				return d;
			}
		}
		return null;
	}
	
	@DeleteMapping(value = "members/{id}", 
			produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String id) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getName().equals(id)) {
				list.remove(i);
			}
		}
		return "1";
	}
	
	
}












