package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_ThiSinh;
import dto.DTO_ThiSinh;

@RestController
public class API_ThiSinh {

	@PostMapping(value = "/thisinh_search")
	@ResponseBody
	public DTO_ThiSinh[] search(@RequestBody DTO_ThiSinh thisinh) {
		ArrayList<DTO_ThiSinh> arr = DAO_ThiSinh.search(thisinh);
		return arr.toArray(new DTO_ThiSinh[arr.size()]);
	}
	
	@PostMapping(value = "/thisinh_create")
	@ResponseBody
	public int create(@RequestBody DTO_ThiSinh thisinh) {
		return DAO_ThiSinh.create(thisinh);
	}
	
	@PostMapping(value = "/thisinh_update")
	@ResponseBody
	public int update(@RequestBody DTO_ThiSinh[] thisinh) {
		return DAO_ThiSinh.update(thisinh[0], thisinh[1]);
	}
	
	@PostMapping(value = "/thisinh_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_ThiSinh thisinh) {
		return DAO_ThiSinh.delete(thisinh);
	}
}