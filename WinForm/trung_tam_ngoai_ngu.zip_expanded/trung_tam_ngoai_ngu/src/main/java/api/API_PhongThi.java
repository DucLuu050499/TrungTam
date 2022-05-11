package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_PhongThi;
import dto.DTO_PhongThi;

@RestController
public class API_PhongThi {

	@PostMapping(value = "/phongthi_search")
	@ResponseBody
	public DTO_PhongThi[] search(@RequestBody DTO_PhongThi phongthi) {
		ArrayList<DTO_PhongThi> arr = DAO_PhongThi.search(phongthi);
		return arr.toArray(new DTO_PhongThi[arr.size()]);
	}
	
	@PostMapping(value = "/phongthi_create")
	@ResponseBody
	public int create(@RequestBody DTO_PhongThi phongthi) {
		return DAO_PhongThi.create(phongthi);
	}
	
	@PostMapping(value = "/phongthi_update")
	@ResponseBody
	public int update(@RequestBody DTO_PhongThi[] phongthi) {
		return DAO_PhongThi.update(phongthi[0], phongthi[1]);
	}
	
	@PostMapping(value = "/phongthi_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_PhongThi phongthi) {
		return DAO_PhongThi.delete(phongthi);
	}
}