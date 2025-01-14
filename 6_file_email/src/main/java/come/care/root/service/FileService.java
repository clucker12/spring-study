package come.care.root.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import come.care.root.dto.FileDTO;

public interface FileService {
	public static String IMG_REPO = "C:/spring/image_repo";
	public void fileProcess(MultipartFile file, String id, String name);
	public List<FileDTO> getList();
	public void delete(String file, String id);
	public void fileUpdate(MultipartFile file, String id, String name, String filename);
}
