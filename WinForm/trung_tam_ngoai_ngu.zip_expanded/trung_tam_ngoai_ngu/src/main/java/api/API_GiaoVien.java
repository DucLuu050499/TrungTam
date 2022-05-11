package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_GiaoVien;
import dto.DTO_GiaoVien;

@RestController
public class API_GiaoVien {

	@PostMapping(value = "/giaovien_search")
	@ResponseBody
	public DTO_GiaoVien[] search(@RequestBody DTO_GiaoVien giaovien) {
		ArrayList<DTO_GiaoVien> arr = DAO_GiaoVien.search(giaovien);
		return arr.toArray(new DTO_GiaoVien[arr.size()]);
	}
	
	@PostMapping(value = "/giaovien_create")
	@ResponseBody
	public int create(@RequestBody DTO_GiaoVien giaovien) {
		return DAO_GiaoVien.create(giaovien);
	}
	
	@PostMapping(value = "/giaovien_update")
	@ResponseBody
	public int update(@RequestBody DTO_GiaoVien[] giaovien) {
		return DAO_GiaoVien.update(giaovien[0], giaovien[1]);
	}
	
	@PostMapping(value = "/giaovien_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_GiaoVien giaovien) {
		return DAO_GiaoVien.delete(giaovien);
	}
}