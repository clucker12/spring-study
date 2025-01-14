package come.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import come.care.root.service.FileService;

@Controller
public class FileController {
	@Autowired FileService fs;
	
	
	
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul, String id, String name,
				MultipartFile file) {
		fs.fileProcess(file, id, name);
//		System.out.println("id : " +id); // id값
//		System.out.println("name : " +name); //name값
//		System.out.println("file : " +file.getOriginalFilename()); //업로드한 파일명
//		System.out.println("-------------------------");
//		System.out.println("id : " + mul.getParameter("id"));
//		System.out.println("mul.name : " + mul.getParameter("name"));
//		MultipartFile mf = mul.getFile("file");
//		System.out.println("mf.file : " + mf.getOriginalFilename());
		
		return "redirect:form";
	}
	@GetMapping("views")
	public String views(Model model) {
		model.addAttribute("list",fs.getList());
		return "result";
	}
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName, 
			HttpServletResponse res) throws Exception {
		//@RequestParam("file")은 받아오는 이름변경 할때 사용
		//URLEncoder.encode은 파일이름 한글일때 인코딩하여 변경할 때 사용
		res.addHeader("Content-disposition", "attachment; filName=" 
				+ URLEncoder.encode(fileName,StandardCharsets.UTF_8) );
		
		File file = new File(FileService.IMG_REPO + "/" + fileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, res.getOutputStream());
		in.close();
	}
	@GetMapping("delete")
	public String delete(String file, String id) {
		fs.delete(file,id);
		return "redirect:views";
	}
	@GetMapping("updateform")
	public String update(String file,String id,
			String name,Model model) {
		 model.addAttribute("id", id);
		 model.addAttribute("name", name);
		 model.addAttribute("filename", file);
		return "update";
	}
	@PostMapping("update")
	public String update(String id, String name,
			MultipartFile file,String filename) {
//		System.out.println("id : " +id); // id값
//		System.out.println("name : " +name); //name값
//		System.out.println("filename : " + filename);
//		System.out.println("multfie : " + file.getOriginalFilename());
		
		fs.fileUpdate(file, id, name,filename);
		return "redirect:views";
	}
}

















