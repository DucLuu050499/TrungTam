package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_KhoaThi;
import dto.DTO_KhoaThi;

@RestController
public class API_KhoaThi {

	@PostMapping(value = "/khoathi_search")
	@ResponseBody
	public DTO_KhoaThi[] search(@RequestBody DTO_KhoaThi khoathi) {
		ArrayList<DTO_KhoaThi> arr = DAO_KhoaThi.search(khoathi);
		return arr.toArray(new DTO_KhoaThi[arr.size()]);
	}
	
	@PostMapping(value = "/khoathi_create")
	@ResponseBody
	public int create(@RequestBody DTO_KhoaThi khoathi) {
		return DAO_KhoaThi.create(khoathi);
	}
	
	@PostMapping(value = "/khoathi_update")
	@ResponseBody
	public int update(@RequestBody DTO_KhoaThi[] khoathi) {
		return DAO_KhoaThi.update(khoathi[0], khoathi[1]);
	}
	
	@PostMapping(value = "/khoathi_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_KhoaThi khoathi) {
		return DAO_KhoaThi.delete(khoathi);
	}
}