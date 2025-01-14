package come.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import come.care.root.dto.FileDTO;
import come.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	FileMapper mapper;
	

	@Override
	public void fileProcess(MultipartFile file, String id, String name) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		
		if(!file.isEmpty()) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			// sysFileName = 20250113105710- 형식으로 저장
			String sysFileName = fo.format(new Date());
			// sysFileName = 20250113105710-파일이름.png 형식으로 저장
			sysFileName += file.getOriginalFilename();
			dto.setImgFileName(sysFileName);
			
			File f = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else {
			dto.setImgFileName("nan");
		}
		
		try {
			mapper.save(dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Override
	public List<FileDTO> getList() {
		
		return mapper.getList();
	}


	@Override
	public void delete(String file, String id) {
		int result = 0;
		try {
			result = mapper.delete(id);
			if(result == 1) {
				File d = new File(IMG_REPO + "/" + file);
				//d.exists()파일 존재 유무 확인
				if(d.exists()) {
					d.delete(); //파일 삭제
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public void fileUpdate(MultipartFile file, String id, String name,String filename) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		int result = 0;
		
		if(!file.isEmpty()) {
		    // 날짜와 시간을 기준으로 파일명을 생성하기 위해 SimpleDateFormat 객체 생성
		    SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
		    // 현재 시간에 맞춰 형식화된 파일명 생성 (예: 20250113105710-)
		    String sysFileName = fo.format(new Date());
		    
		    // 원본 파일명을 추가하여 최종 파일명 생성 (예: 20250113105710-파일이름.png)
		    sysFileName += file.getOriginalFilename();
		    
		    // 생성한 파일명을 DTO에 세팅 (DB에 저장될 파일명)
		    dto.setImgFileName(sysFileName);
		    
		    // 저장될 경로와 파일명으로 File 객체 생성
		    File f = new File(IMG_REPO + "/" + sysFileName);
		    
		    try {
		        // 업로드된 파일을 지정된 경로에 저장
		        file.transferTo(f);
		    } catch (Exception e) {
		        // 예외가 발생하면 스택 트레이스를 출력
		        e.printStackTrace();
		    } 
		} else {
		    // 만약 파일이 비어 있다면 (업로드된 파일이 없다면) 기존 파일명을 그대로 DTO에 설정
		    dto.setImgFileName(filename);
		}

		try {
			result = mapper.update(dto);
			if(result == 1) {
				File d = new File(IMG_REPO + "/" + filename);
				System.out.println("file d : " + d);
				//d.exists()파일 존재 유무 확인
				if(!dto.getImgFileName().equals(filename)) {
					d.delete(); //파일 삭제
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
}

















