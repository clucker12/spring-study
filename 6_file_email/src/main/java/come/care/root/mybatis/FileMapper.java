package come.care.root.mybatis;

import java.util.List;

import come.care.root.dto.FileDTO;

public interface FileMapper {
	public void save(FileDTO dto);
	public List<FileDTO> getList();
	public int delete(String id);
	public int update(FileDTO dto);
}
